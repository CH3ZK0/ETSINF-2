import java.net.*;
import java.io.*;

public class Hilos extends Thread{
    
    String frase;
    
    public Hilos(String s){
        frase = s;
    }
    
    public void run(){
        for(int i=1; i<=10; i++){
            System.out.println(frase + i);
            try{sleep(100);}catch(InterruptedException e){}
        }
    }
}
