import java.net.*;
import java.io.*;
import java.util.*;

public class HilosServicio extends Thread{
    
    Socket id;
    
    public HilosServicio(Socket s){
        id = s;
    }
    
    public void run(){
        
        try{
            
            PrintWriter salida = new PrintWriter(id.getOutputStream(), true);
            
            Scanner entrada = new Scanner(id.getInputStream());
            String linea = entrada.nextLine();
			
            while(!linea.equals("FIN")){
                linea = entrada.nextLine();
                salida.println(linea);
                salida.flush();
            }
            
        }catch(Exception e){}
    }
}