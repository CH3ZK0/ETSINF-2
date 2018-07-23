 
/**
 * Write a description of class PilaAL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;

/** la siguiente linea tambien ha de modificarse */
public class PilaAL<T> implements Pila<T>{
    
    ArrayList<T> pila = new ArrayList<T>();
    
    public void apilar(T e){
       pila.add(e);
    }
    
    public T desapilar(){
       if(pila.isEmpty()) return null;
       return pila.remove(pila.size()-1);
    }
    
    public T cima(){
       if(pila.isEmpty()) return null;
       return desapilar();
    }
    
    public boolean esVacia(){
       return pila.isEmpty();
    }
    
    public int talla(){
       return pila.size();
    }
    
    public String toString(){
        String res = "";
        if(pila.isEmpty()){
            return res = "Pila vacia";
        }
        for(int i=pila.size()-1; i>=0; i--){
            if(i==pila.size()-1){
                res += "cima: "+ pila.get(i);
            }else{
                res += " / "+pila.get(i) ;
            }
        }     
        return res;
    }   
}
