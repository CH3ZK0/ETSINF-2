package librerias.implementacionesDeModelos;

/**
 *TAD de una cola implementado con un array circular de amplitud variable
 * 
 * @author (Professors LTPP) 
 */
import librerias.modelos.Cola;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ColaAL <T> implements Cola <T> { 
    //Definicion de los atributos necesarios:
    //elArray, una array de tipo generico T para guardar los elementos de la cola
    private static final int MAX = 10;
    private ArrayList <T> elArray;
    
    /**Constructor de Cola */
    //El compilador nos avisa (warning) de que el tipo puro correspondiente a T en (1) se aplicara
    //en tiempo de ejecucion. Con esta directiva le decimos que no nos muestre el aviso ya que la coercion es segura.
    @SuppressWarnings({"unchecked"})
    public ColaAL () {
        elArray = new ArrayList <T> (MAX); //(1)
    }//Fin del constructor ColaAC<T>
    
    // Implementacion de las operaciones del TAD definido en la interfaz Pila <T>:
    // Metodos modificadores del estado de una cola:
    
    /** Inserta el Elemento e en una cola situandolo al final **/
    
    public void encolar(T e){
        //COMPLETAR
        elArray.add(e);
    }//Fin del metodo void encolar(T)
    
    /** Consulta y extrae el primer elemento, solo si la cola no esta vacia.**/
    public T desencolar(){
        
        //COMPLETAR
        if (elArray.size() == 0) { 
            throw new NoSuchElementException("Cua buida");
        }
        return elArray.remove(0);
        
    }//Fin del metodo T desencolar()
    
    // Metodos consultores del estado de la cola
    /** Devuelve la cantidad de elementos  de la cola **/
    public int talla(){
        //COMPLETAR
        return elArray.size();
    }//Fin del metodo T talla
    
    /** Solo si la cola no esta vacia, consulta el primer elemento en cabeza,
    * (el primero en orden de insercion) **/
    public T primero() {
        //COMPLETAR
        if (elArray.size() == 0) { 
            throw new NoSuchElementException("Cua buida");
        }
        return elArray.get(0);
    }//Fin del metodo T primero()
    
    /** Comprueba si una cola esta vacia **/
    public boolean esVacia(){
        //COMPLETAR
        return elArray.size() == 0;
    }//Fin del metodo boolean esVacia()
    
    /** Devuelve el contenido de la cola con el formato 
    <-elem0<-elem1<-elem2<-...<-elemN<- donde N = talla()-1
    Cada elemi se devuelve con el formato que este definido para su tipo
    **/ 
    public String toString (){
        //COMPLETAR
        String s = "";
        for (int i = 0; i < elArray.size(); i++) {
            s += String.format("%4d", elArray.get(i));
        }
        return s;
    }//Fin del metodo String toString()
}