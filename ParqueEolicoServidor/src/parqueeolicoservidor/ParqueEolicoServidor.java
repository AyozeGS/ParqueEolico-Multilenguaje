/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueeolicoservidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import static parqueeolicoservidor.Estado.*;

/**
 *
 * @author Ayo
 */
public class ParqueEolicoServidor {

    final static int DEFAULT_PORT = 44444;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int Puerto;
        try{
            Puerto = Integer.parseInt(args[0]);
        }catch(NumberFormatException | ArrayIndexOutOfBoundsException ex){
            Puerto = DEFAULT_PORT;
        }
        ArrayList<Aerogenerador> listaAerogeneradores = 
                new ArrayList<Aerogenerador>(){{
                    add(new Aerogenerador(0,DESACTIVADO));
                    add(new Aerogenerador(1,ACTIVADO));
                    add(new Aerogenerador(2,ACTIVADO));
                    add(new Aerogenerador(3,DESACTIVADO));
                    add(new Aerogenerador(4,ACTIVADO));
        }};
        // El servidor crea un hilo cuando un cliente solicita comunicarse
        try {
            ServerSocket serverSocket = new ServerSocket(Puerto);
            while(true){
                Socket socket = serverSocket.accept();
                ParqueEolicoHilo hilo = new ParqueEolicoHilo(
                        socket, listaAerogeneradores);
                hilo.start();
            }
        } catch (IOException ex) {
            System.out.println("Error durante la escucha del puerto.");
        }        
    }
}