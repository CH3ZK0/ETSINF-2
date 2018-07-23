import java.net.*;
import java.io.*;

public class Main{
    
    public static void main(String args[]){
        for(int i=1; i<=3; i++){
            Hilos h = new Hilos("Hilo: " + i + " Hola mundo iteracion: ");
            h.start();
        }
    }
}