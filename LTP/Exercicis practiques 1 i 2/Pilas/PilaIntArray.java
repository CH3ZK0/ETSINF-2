
/**
 * Write a description of class PilaIntArray here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/** ESTA CLASE NO DEBE MODIFICARSE: 
    SE FACILITA COMO UNA REFERENCIA DE 
    IMPLEMENTACION CORRECTA DE 
    UNA CLASE PILA DE ENTEROS USANDO ARRAY
   */
  
import java.util.NoSuchElementException;

public class PilaIntArray {
   private int[] elArray;
   private int cima;
   private static final int MAX = 10;
   
   public PilaIntArray () {
      elArray = new int[MAX];
      cima = -1;
   }
   
   private void duplicaArray () {
      int[] aux = new int[2*elArray.length]; 
      for (int i=0; i<elArray.length; i++) 
         aux[i] = elArray[i]; 
      elArray = aux;
   }
   
   public void apilar (int x) {
      if ( cima+1 == elArray.length ) duplicaArray();
      elArray[++cima] = x;
   }
    
   public int desapilar () {
      if ( cima < 0 ) throw new NoSuchElementException("Pila vacia");
      return elArray[cima--];
   }

   public int cima () { 
      if ( cima < 0 ) throw new NoSuchElementException("Pila vacia");
      return elArray[cima]; 
   }

   public boolean esVacia () { 
      return cima == -1; 
   }

   public int talla () { 
      return cima+1;
   }
   
   /** Devuelve el contenido de la pila con el formato 
        cima: elem0 || elem1 || elem2 || ... || elemN donde N = talla()-1
   */ 
   public String toString () {        
      if ( esVacia() ) return "pila vacia";
      int i = cima;
      String s = "cima: "+elArray[i];
      while (i > 0) s += " / "+elArray[--i];
      return s;
   } 
}
