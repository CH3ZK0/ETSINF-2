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
    ArrayList<T> array = new ArrayList<T>();
   // A COMPLETAR: atributos y metodos   
    /** inserta un nuevo elemento en el GrupoDe */
    public void anyade(T e){
        array.add(e);
    }
    
    /** Comprueba si existe un elemento en el GrupoDe */
    public boolean existe(T e){
        for(int i=0; i<array.size();i++){
            if(array.get(i).equals(e)){
                return true;
            }
        }
        return false;
    }
    
    /** Retorna el numero de elementos en el GrupoDe */
    public int talla(){
        return array.size();
    }
    
    /** Elimina, solo si existe, un elemento del GrupoDe 
     *  Devuelve el elemento si ha podido eliminarlo, 
     *  null en caso contrario     */ 
    public T elimina (T e){
        if(existe(e)){
            for(int i=0; i<array.size()-1;i++){
                if(array.get(i).equals(e)){
                    return array.remove(i);
                }
            }
        }
        return null;
    }
    
    /** Retorna si el GrupoDe esta vacio */
    public boolean esVacio(){
        return array.isEmpty();
    }
    
    
}    

