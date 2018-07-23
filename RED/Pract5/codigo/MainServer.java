import java.net.*;
import java.io.*;

public class MainServer{
    
    public static void main(String args[])throws UnknownHostException, IOException{
        int puerto=7777;
        
        ServerSocket servidor = new ServerSocket(puerto);
        
        while (true) {
            Socket cliente = servidor.accept();
            
            HilosServicio Cl = new HilosServicio(cliente);
            
            Cl.start();
        }
    }
}
