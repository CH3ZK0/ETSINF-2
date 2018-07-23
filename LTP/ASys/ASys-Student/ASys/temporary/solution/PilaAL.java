 
/**
 * Write a description of class PilaAL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class PilaAL <T> implements Pila<T> {
   private ArrayList<T> elArray;
  
   public PilaAL () {
      elArray = new ArrayList<T>();  
   } 
   
   public void apilar (T e) {
      elArray.add(e); 
   } 
  
   public T desapilar () {
      return elArray.remove( talla()-1 );
   } 
  
   public T cima () {
      return elArray.get( talla()-1 ); 
   } 

   public boolean esVacia () {
      return elArray.isEmpty(); 
   }

   public int talla () {
      return elArray.size();
   } 

   /** Devuelve el contenido de la pila con el formato 
       cima: elem0 || elem1 || elem2 || ... || elemN donde N = talla()-1
       Cada elemi se devuelve con el formato que este definido para su tipo 
   */ 
   public String toString () {
      if ( esVacia() ) return "pila vacia";
      String s = "cima: "+elArray.get(talla()-1);
      for (int k=talla()-2; k>=0; k--) s += " / "+elArray.get(k);
      return s;
   } 
}
