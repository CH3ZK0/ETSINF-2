 

import librerias.util.Ordenacion;
import java.util.Arrays;
import java.util.Locale;

/** 
 *  La clase TestOrdenacion permite probar y temporizar los  
 *  metodos de ordenacion de arrays genericos definidos en  
 *  la clase librerias.util.Ordenacion.
 *  
 *  @author (EDA) 
 *  @version (Curso 2015-2016)
 */

public class TestOrdenacion {

    /**
     * Comprueba la correccion del metodo mergeSort2 de 
     * la clase Ordenacion, basandose en la correccion
     * del metodo quickSort.
     */
    public static void comprobar() {
        Integer[] a1 = crearAleatorioInteger(100000);
        Integer[] a2 = Arrays.copyOf(a1, a1.length);

        // A completar: comprobar que mergeSort2 ordena 
        // correctamente, usando el metodo sonIguales de 
        // la clase Ordenacion para comparar su resultado  
        // con el de quickSort        
    }

    /**
     * Temporizacion sobre Integer de los metodos mergeSort1,  
     * mergeSort2 y quickSort de la clase Ordenacion.
     */
    public static void temporizar() {
        final int INI = 10000;
        final int FI = 100000;
        final int INC = INI;
        final int numRep = 200;
        double t1, t2, tacum1, tacum2, tacum3;
        Integer[] aux1, aux2, aux3;
        
        System.out.println("#----------------------------------------------");        
        System.out.println("# Comparacion entre quickSort y mergeSort: ");
        System.out.println("# Tiempos en milisegs. Valores Integer.");
        System.out.println("#----------------------------------------------");
        System.out.println("#  Talla    mergeSort1   mergeSort2   quickSort");
        System.out.println("#----------------------------------------------");
        for (int k = INI; k <= FI; k = k + INC) {
            int talla = k;
            t1 = 0; t2 = 0; 
            tacum1 = 0; tacum2 = 0; tacum3 = 0;
            for (int i = 1; i <= numRep; i++) {
                aux1 = crearAleatorioInteger(talla);
                aux2 = Arrays.copyOf(aux1, aux1.length);
                aux3 = Arrays.copyOf(aux1, aux1.length);
                                             
                t1 = System.nanoTime();
                Ordenacion.mergeSort1(aux1);
                t2 = System.nanoTime();
                tacum1 += t2 - t1;    
                
                //  A completar:  
                //  Temporizacion de mergeSort2
                
                
                t1 = System.nanoTime();
                Ordenacion.quickSort(aux3);
                t2 = System.nanoTime();
                tacum3 += t2 - t1;                                                                                                             
            }
                      
            System.out.printf(Locale.US,
                              "%1$8d %2$12.4f %3$12.4f %4$12.4f\n",
                              talla, 
                              tacum1 / numRep / 1e6, 
                              tacum2 / numRep / 1e6,
                              tacum3 / numRep / 1e6);
        }
    }
           
    /**
     * Devuelve un array de talla Integer generados aleatoriamente.
     * 
     * @param talla  Talla del array resultado
     * 
     * @return Integer[]
     */
    public static Integer[] crearAleatorioInteger(int talla) {
        Integer[] aux = new Integer[talla];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = (int) (Math.random() * (10 * talla));
        }
        return aux;
    }

    /**
     * Temporizacion sobre String de los metodos mergeSort1,
     * mergeSort2 y quickSort de la clase Ordenacion.
     */
    public static void temporizarString() {
        final int INI = 10000;
        final int FI = 100000;
        final int INC = INI;
        final int numRep = 100;
        final int charIgual = 30;
        double t1, t2, tacum1, tacum2, tacum3;
        String[] aux1, aux2, aux3;
        
        System.out.println("#----------------------------------------------");        
        System.out.println("# Comparacion entre quickSort y mergeSort: ");
        System.out.println("# Tiempos en milisegs. Valores String.");
        System.out.println("#----------------------------------------------");
        System.out.println("#  Talla    mergeSort1   mergeSort2   quickSort");
        System.out.println("#----------------------------------------------");
        for (int k = INI; k <= FI; k = k + INC) {
            int talla = k;
            t1 = 0; t2 = 0; 
            tacum1 = 0; tacum2 = 0; tacum3 = 0;
            for (int i = 1; i <= numRep; i++) {
                aux1 = crearAleatorioString(talla, charIgual);
                aux2 = Arrays.copyOf(aux1, aux1.length);
                aux3 = Arrays.copyOf(aux1, aux1.length);
                                             
                t1 = System.nanoTime();
                Ordenacion.mergeSort1(aux1);
                t2 = System.nanoTime();
                tacum1 += t2 - t1;    
                
                // A completar: 
                // Temporizacion de mergeSort2                               
                                                                
                t1 = System.nanoTime();
                Ordenacion.quickSort(aux3);
                t2 = System.nanoTime();
                tacum3 += t2 - t1;                                                                                                      
            }
                      
            System.out.printf(Locale.US,
                              "%1$8d %2$12.4f %3$12.4f %4$12.4f\n",
                              talla, 
                              tacum1 / numRep / 1e6, 
                              tacum2 / numRep / 1e6,
                              tacum3 / numRep / 1e6);
        }
    } 
    
    /**
     * Devuelve un array de talla String aleatorios con los primeros n 
     * caracteres iguales.
     * 
     * @param talla  Talla del array resultado
     * @param n  Numero de caracteres iniciales iguales
     * @return String[]
     */    
    public static String[] crearAleatorioString(int talla, int n) {
        /*COMPLETAR*/
    }
    
    public static void main(String[] args) { 
        temporizar();
        temporizarString();
    }                
}

