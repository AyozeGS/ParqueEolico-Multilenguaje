/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueeolicocliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ayo
 */
public class ParqueEolicoCliente {

    final static int DEFAULT_PORT = 44444;
    final static String DEFAULT_HOST = "localhost";
    final static int DEFAULT_IDIOMA = 0;
    static int idioma;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int Puerto;
        String Host;
        try{
            Host = args[0];  
        }catch(ArrayIndexOutOfBoundsException ex){
            Host = DEFAULT_HOST;
        }
        try{
            Puerto = Integer.parseInt(args[1]);
        }catch(NumberFormatException | ArrayIndexOutOfBoundsException ex){
            Puerto = DEFAULT_PORT;
        }
        try{
            idioma = Code.lenguajes.get(args[2]);
        }catch(ArrayIndexOutOfBoundsException | NullPointerException ex){
            idioma = DEFAULT_IDIOMA;
        } 
        
        //Se inicia la comunicación con el servidor con un socket
        try {
            Socket socket = new Socket(Host, Puerto);
            comunicacionServidor(socket);
        } catch (IOException ex) {
            System.out.println(Code.mensajes.get("ERROR401")[idioma]);
        }
    }

    private static void comunicacionServidor(Socket socket){
        
        try {
            Scanner scanner = new Scanner(System.in);
            DataInputStream flujo_entrada = new DataInputStream(
                    socket.getInputStream());
            DataOutputStream flujo_salida= new DataOutputStream(
                    socket.getOutputStream());
            int opcion_menu, num_aero, id_aero, estado, velocidad;

            System.out.print(Code.mensajes.get("MSGC001")[idioma]);
            flujo_salida.writeUTF(scanner.nextLine());
            
            //Bucle envío y recepción con el servidor
            while(true){
                System.out.print(Code.mensajes.get("MSGMENU")[idioma]); 
                //Envío de la opción
                try {
                    opcion_menu = Integer.parseInt(scanner.nextLine());
                } catch(NumberFormatException | InputMismatchException ex){
                    opcion_menu = -1;
                }
                if (opcion_menu >= 0 && opcion_menu <= 5){
                    flujo_salida.writeInt(opcion_menu);
                    if (!flujo_entrada.readBoolean())
                        opcion_menu = -1;
                }
                //Gestión de las opciones
                switch(opcion_menu){
                    case 1:
                        num_aero = flujo_entrada.readInt();
                        System.out.print(Code.mensajes.get("MSGC101")[idioma]+
                                Integer.toString(num_aero));
                        System.out.print(Code.mensajes.get("MSGCLIST")[idioma]); 
                        for (int i = 0; i < num_aero; i++){
                            id_aero = flujo_entrada.readInt();
                            estado = flujo_entrada.readInt();
                            velocidad = flujo_entrada.readInt();
                        System.out.println(Code.mensajes.get("AEROGENERADOR")[idioma]+": " 
                                + id_aero + ", "+Code.mensajes.get("ESTADO")[idioma]+": " 
                                + Estado.values()[estado].idiomas[idioma]
                                + ", "+Code.mensajes.get("VELOCIDAD")[idioma]+": " + velocidad + " m/s");
                        }
                        System.out.println("---------------------------------------------------------");
                        break;
                    case 2:
                        System.out.print(Code.mensajes.get("MSGC102")[idioma]);
                        flujo_salida.writeUTF(scanner.nextLine());
                        System.out.println(Code.mensajes.get(
                                flujo_entrada.readUTF())[idioma]);
                        break;
                    case 3:
                        System.out.print(Code.mensajes.get("MSGC103")[idioma]);
                        flujo_salida.writeUTF(scanner.nextLine());
                        System.out.println(Code.mensajes.get(
                                flujo_entrada.readUTF())[idioma]);
                        break;
                    case 4:
                        System.out.print(Code.mensajes.get("MSGC104")[idioma]);
                        flujo_salida.writeUTF(scanner.nextLine());
                        System.out.println(Code.mensajes.get(
                                flujo_entrada.readUTF())[idioma]);
                        break;
                    case 5:
                        System.out.print(Code.mensajes.get("MSGC105")[idioma]);
                        flujo_salida.writeUTF(scanner.nextLine());
                        System.out.println(Code.mensajes.get(
                                flujo_entrada.readUTF())[idioma]);
                        break;
                    case 0:
                        if (socket.isConnected())
                            socket.close();
                        System.out.println(Code.mensajes.get("MSGC100")[idioma]);
                        System.exit(0);
                        break;
                    default:
                        System.out.println(Code.mensajes.get("MSGC199")[idioma]);
                }
            }
        } catch (IOException ex) {
            System.out.println(Code.mensajes.get("ERROR402")[idioma]);
        } 
    }
}
