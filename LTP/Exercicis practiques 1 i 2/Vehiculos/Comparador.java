
/**
 * Write a description of class Comparador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comparador<T extends Figura > implements Posicion{
    T v1,v2;
    public Comparador(){
   
    }
    
    public Comparador(T v1,T v2){
      this.v1 = v1;
      this.v2 = v2;
       
    }  
    public double obtenerCoordenadaX(){
        return 0.0;
    }
    public double obtenerCoordenadaY(){
        return 0.0;
    }
    
    public boolean compararPosiciones(){
        return this.v1.obtenerCoordenadaX()==this.v2.obtenerCoordenadaX()
        && this.v1.obtenerCoordenadaY()==this.v2.obtenerCoordenadaY();
    }
}
