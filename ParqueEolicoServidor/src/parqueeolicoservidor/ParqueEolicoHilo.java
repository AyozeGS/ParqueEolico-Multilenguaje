/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueeolicoservidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import static parqueeolicoservidor.Estado.*;

/**
 *
 * @author Ayo
 */
public class ParqueEolicoHilo extends Thread {
    
    Socket socket;
    ArrayList<Aerogenerador> listaAerogeneradores;

    public ParqueEolicoHilo(Socket socket, ArrayList<Aerogenerador> listaAero){
        this.socket = socket;
        this.listaAerogeneradores = listaAero;
    }
    
    @Override
    public void run() {
        
        int opcion_menu;
        boolean fin = false;
        String ip = socket.getInetAddress().getHostAddress();
        String cliente = null;
        
        try {    
            DataInputStream flujo_entrada = 
                    new DataInputStream(this.socket.getInputStream());
            DataOutputStream flujo_salida= 
                    new DataOutputStream(this.socket.getOutputStream());
            
            cliente = flujo_entrada.readUTF(); //Nombre del cliente
            System.out.println("Cliente conectado: "+cliente+"("+ip+")");
            
            //Bucle envío y recepción con el cliente
            while(!fin){
                //Recogida de la opción
                opcion_menu = flujo_entrada.readInt();
                if (opcion_menu >= 0 && opcion_menu <= 5){
                    flujo_salida.writeBoolean(true);
                }
                else{
                    flujo_salida.writeBoolean(false);
                    opcion_menu = -1;
                }
                //Gestión de las opciones
                switch(opcion_menu){
                    case 1:
                        System.out.println(cliente+"("+ip+") solicita opción 1");
                        flujo_salida.writeInt(listaAerogeneradores.size());
                        for (Aerogenerador a : listaAerogeneradores){
                            flujo_salida.writeInt(a.getId());
                            flujo_salida.writeInt(a.getEstado().ordinal());
                            flujo_salida.writeInt(a.getVelocidad());
                        }
                        break;
                    case 2:
                        System.out.println(cliente+"("+ip+") solicita opción 2");
                        flujo_salida.writeUTF(activar_aerogenerador(
                                checkId(flujo_entrada.readUTF())));
                        break;
                    case 3:
                        System.out.println(cliente+"("+ip+") solicita opción 3");
                        flujo_salida.writeUTF(desactivar_aerogenerador(
                                checkId(flujo_entrada.readUTF())));
                        break;
                    case 4:
                        System.out.println(cliente+"("+ip+") solicita opción 4");
                        flujo_salida.writeUTF(añadir_aerogenerador(
                                checkId(flujo_entrada.readUTF())));
                        break;
                    case 5:
                        System.out.println(cliente+"("+ip+") solicita opción 5");
                        flujo_salida.writeUTF(eliminar_aerogenerador(
                                checkId(flujo_entrada.readUTF())));
                        break;
                    case 0:
                        if (socket.isConnected())
                            socket.close();
                        System.out.println("Desconectado: "+cliente+"("+ip+")");
                        fin = true;
                        break;
                    default:
                        System.out.println(cliente+"("+ip+") elige opción inválida");
                }
            }
        } catch (IOException ex) {
            System.out.println("Error: "+cliente+"("+ip+") desconectado");
        } 
    }
    
    public int checkId(String entrada){
        try{
            int id = Integer.valueOf(entrada);
            if (id < 0)
                return -1;
            return id;
        } catch (NumberFormatException ex){
            return -1;
        } 
    }

    public Aerogenerador get_aerogenerador(int idAerogenerador){
        for (Aerogenerador aerogenerador : listaAerogeneradores){
            if (idAerogenerador == aerogenerador.getId()){
                return aerogenerador;
            }
        }
        return null;
    }
    
    public String activar_aerogenerador (int idAerogenerador){
        Aerogenerador aerogenerador = get_aerogenerador(idAerogenerador);
        if (aerogenerador == null)
            return "WNGS401";
        else {
            if (aerogenerador.getEstado() == Estado.DESACTIVADO){
                aerogenerador.setEstado(ACTIVADO);
                return "MSGS102";
            }
            else
                return "WNGS402";
        }
    }
    public String desactivar_aerogenerador(int idAerogenerador){
        Aerogenerador aerogenerador = get_aerogenerador(idAerogenerador);
        if (aerogenerador == null)
            return "WNGS401";
        else {
            if (aerogenerador.getEstado() == Estado.ACTIVADO){
                aerogenerador.setEstado(DESACTIVADO);
                return "MSGS103";
            }
            else
                return "WNGS403";
        }
    }
    public String añadir_aerogenerador(int idAerogenerador){
        if (idAerogenerador == -1)
            return "WNGS400";
        else {
            if (get_aerogenerador(idAerogenerador) == null){
                listaAerogeneradores.add(
                        new Aerogenerador(idAerogenerador, DESACTIVADO));
                return "MSGS104";
            }
            else
                return "WNGS404";
        }
    }  
    public String eliminar_aerogenerador(int idAerogenerador){
        Aerogenerador aerogenerador = get_aerogenerador(idAerogenerador);
        if (aerogenerador == null)
            return "WNGS401";
        else{
            listaAerogeneradores.remove(aerogenerador);
            return "MSGS105";
        }
    }
}
