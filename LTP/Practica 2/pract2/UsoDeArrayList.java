import java.io.*;
import java.util.*;

public class UsoDeArrayList
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner lec = null;
        ArrayList<String> llista = null;
        try{
            String fitxer = "textoPruebaEjercicio2.txt";
            File fd = new File(fitxer);
            lec = new Scanner(fd);
        }catch(IOException e){
            System.out.println("Fitcher no trobat");
        }
        while(lec.hasNext()){
            llista.add(lec.nextLine());
        }
        Collections.sort(llista);
        llista.toString();
        lec.close();
    }
}