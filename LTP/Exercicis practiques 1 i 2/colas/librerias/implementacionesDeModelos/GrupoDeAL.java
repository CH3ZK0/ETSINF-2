package librerias.implementacionesDeModelos;

import java.util.*;
import librerias.modelos.*;

/**
 * Implementa el modelo GrupoDe mediante un ArrayList.
 * 
 * @author (LTPP) 
 * @version (2014-15)
 */
public class GrupoDeAL<T> implements GrupoDe<T> {
   ArrayList<T> list = new ArrayList<T>();
   // A COMPLETAR: atributos y metodos   
   public boolean esVacio(){
       if(list.isEmpty()){
           return true;
        }
       return false;
   }
    
   public int talla(){
       return list.size();
   }
   
   public T elimina (T e){
            T a;
           for(int i=0; i < list.size(); i++){
               
               if(list.get(i).equals(e)){
                   a = list.get(i);
                   list.remove(i);
                   return a;
                }      
            }
           return null;
   } 
   
   public boolean existe(T e){
       for(int i=0; i < list.size(); i++){
           
           if(list.get(i).equals(e)){
               return true;
            }
            
        }
       return false;
   }
   
   public void anyade(T e){
       list.add(e);
   }
}    

