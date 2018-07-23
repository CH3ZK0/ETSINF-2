 
/**
 * Write a description of class PilaAL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;

/** la siguiente linea tambien ha de modificarse */
public class PilaAL<T> implements Pila<T>{
    ArrayList<T> array = new ArrayList<T>();
   public void apilar(T e){
       array.add(e);
    }
   public T desapilar(){
       return array.remove(array.size()-1);
    }
   public T cima(){
       return array.get(array.size()-1);
    }
   public boolean esVacia(){
       return array.isEmpty();
    }
   public int talla(){
       return array.size();
    }
   public String toString () {        
      if(array.isEmpty()){ return "pila vacia";}
      int i = array.size()-1;
      String s = "cima: "+array.get(i);
      while (i > 0){ s += " / "+array.get(--i);}
      return s;
   } 
}
