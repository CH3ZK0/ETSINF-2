 
/**
 * Write a description of class Pila<T> here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/** ESTA INTERFAZ NO DEBE MODIFICARSE
 */
  
public interface Pila<T> {
   void apilar(T e);
   T desapilar();
   T cima();
   boolean esVacia();
   int talla();
}
