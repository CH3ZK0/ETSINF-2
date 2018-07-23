
/**
 * Write a description of class Vehiculo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 abstract class Vehiculo  extends Figura implements Posicion
{
    double coorX; double coorY;
     public Vehiculo(double coorX , double coorY  ){
        super(coorX,coorY);
    }
    
}
