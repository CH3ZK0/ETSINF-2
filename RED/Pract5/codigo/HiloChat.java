import java.net.*;
import java.io.*;
import java.util.*;

public class HiloChat extends Thread{
    
    Socket id;
    
    public HiloChat(Socket s){
        id = s;
    }
    
    public void run(){
        Scanner entrada = null;
        
        try{
            entrada = new Scanner(id.getInputStream());
            String linea = entrada.nextLine();
			
            while(!linea.equals("FIN")){
                linea = entrada.nextLine();
                System.out.println(linea);
            }
            
        }catch(Exception e){}
        finally{
            if(entrada != null){ entrada.close();}
            try{id.close();}catch(Exception e){}
        }
    }
}