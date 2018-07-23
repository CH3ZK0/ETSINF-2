package librerias.modelos;


/** 
 * @author (LTPP) 
 * @version (2014-15)
 */
public interface GrupoDe<T> {
    
    /** inserta un nuevo elemento en el GrupoDe */
    public void anyade(T e);
    
    /** Comprueba si existe un elemento en el GrupoDe */
    public boolean existe(T e);
    
    /** Retorna el numero de elementos en el GrupoDe */
    public int talla();
    
    /** Elimina, solo si existe, un elemento del GrupoDe 
     *  Devuelve el elemento si ha podido eliminarlo, 
     *  null en caso contrario     */ 
    public T elimina (T e);
    
    /** Retorna si el GrupoDe esta vacio */
    public boolean esVacio();
}
