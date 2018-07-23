import java.net.*;
import java.io.*;
import java.util.*;

public class MainChat{
    
    
    public static void main(String args[])throws UnknownHostException, IOException{
        int puerto = 7777;
        String host = "rdc00.redes.upv.es";
        
        Socket client = new Socket(host, puerto);
        
        HiloChat chat = new HiloChat(client);
        chat.start();
        
        Scanner t = new Scanner(System.in);
        PrintWriter salida = null;
        
        try{
            salida = new PrintWriter(client.getOutputStream(), true);
            
            String linea = "";
            
            while(!linea.equals("FIN")) {
                linea = t.nextLine();
                
                salida.println(linea);
                salida.flush();
            }
            
        }catch(IOException e){}
        finally{
            if(salida != null){ salida.close();}
            client.close();
        }
    }
}