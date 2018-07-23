package librerias.estructurasDeDatos.jerarquicos;

// comprueba que lo has puesto en el lugar correcto
// package librerias.estructurasDeDatos.jerarquicos;

import librerias.estructurasDeDatos.modelos.ColaPrioridad;
import java.util.PriorityQueue;

/** Implementacion de una Cola de Prioridad mediante una PriorityQueue (Heap) 
  *
  * @version Febrero 2017 
  * @param <E> tipo de datos de la estructura, debe implementar Comparable<E>
  */

public class PriorityQColaPrioridad <E extends Comparable<E>>
    extends PriorityQueue <E>
    implements ColaPrioridad<E>{
    /* COMPLETAR con extends y con implements)
    
    /** crea una Cola de Prioridad (CP) vacia */
    public PriorityQColaPrioridad() { super(); }
    
    /** atendiendo a su prioridad, inserta el Elemento e en una Cola 
     * de Prioridad (CP)
     *  @param e Elemento a agnadir a una Cola de Prioridad
     */
    public void insertar(E e) { /* COMPLETAR */ super.add(e);}
    
    /** SII !esVacia(): obtiene el Elemento con maxima prioridad de una CP 
     * @return E Elemento con maxima prioridad de una CP
     */
    public E recuperarMin() { 
        E res = null;
        /* COMPLETAR */ 
        if(!esVacia()){
            res = super.peek();
        }
        return res; 
    }
    
     /** SII !esVacia(): obtiene y elimina el Elemento con maxima 
      * prioridad de una CP 
     *  @return E Elemento con maxima prioridad de una CP
     */
    public E eliminarMin() { 
        E res = null;
        /* COMPLETAR */
        if(!esVacia()){
            res = super.remove();
        }
        return res; 
    }
    
    /** comprueba si una Cola de Prioridad esta vacia
      * @return true si una CP esta vacia y false en caso contrario
      */
    public boolean esVacia() {
        /* COMPLETAR */ 
        return super.isEmpty(); 
    }
}