package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.ListaConPI;

public class LEGListaConPI <E> implements ListaConPI<E>{
    private NodoLEG<E> pri;
    private NodoLEG<E> ult;
    private NodoLEG<E> ant;
    int talla;
    
    public LEGListaConPI(){
        pri = ult = ant = new NodoLEG<E>(null, null);
        talla = 0;
    }
    
    // metodos Modificadores del estado de la Lista Con PI:
    /** inserta e en una Lista antes del Elemento que ocupa su PI,
    * que permanece inalterado **/
    public void insertar(E e){
        NodoLEG<E> nuevo = new NodoLEG(e);
        ++this.talla;

        nuevo.siguiente = ant.siguiente;
        ant.siguiente = nuevo;

        if(ant == ult) ult = nuevo;

        ant = nuevo;
    }
    
     /** SII !esFin(): elimina de una Lista el Elemento que ocupa su PI,
    * que permanece inalterado **/
    public void eliminar(){
        if(ant.siguiente == ult){
           ult = ant;
        }
        ant.siguiente = ant.siguiente.siguiente;
        talla--;
    }
    
    // metodos Modificadores del estado del PI de la Lista:
    /** situa el PI de una Lista en su inicio */
    public void inicio(){ant = pri;}
    
    /** SII !esFin(): avanza el PI de una Lista */
    public void siguiente(){if(!esFin()) ant = ant.siguiente;}
    
    /** situa el PI de una Lista en su fin */
    public void fin(){ant = ult;}
   
    // metodos Consultores del estado de la Lista Con PI:
    /** SII !esFin(): obtiene el Elemento que ocupa el PI de una Lista */
    public E recuperar(){
        return ant.siguiente.dato;
    }
    
    /** comprueba si el PI de una Lista esta en su fin */
    public boolean esFin(){return ant == ult;}
    
    /** comprueba si una Lista Con PI esta vacia **/
    public boolean esVacia(){return pri == ult;}
    
    /** devuelve la talla de una Lista, o su numero de elementos **/
    public int talla(){return talla;}
    
    public String toString() {
        // NOTA: se usa la clase StringBuilder, en lugar de String,
        // por motivos de eficiencia
        StringBuilder s = new StringBuilder();
        
        s.append("[");
        
        NodoLEG<E> aux = pri.siguiente;
        
        for (int i = 1; i < talla; i++, aux = aux.siguiente) {
            s.append(aux.dato.toString());
            s.append(", ");
        }
        
        if (talla != 0) {
            s.append(aux.dato.toString());
            s.append("]");
        } else { s.append("]"); }
        
        return s.toString();
    }
}
