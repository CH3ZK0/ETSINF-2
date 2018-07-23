
/**
 * Clase utilizada para representar un coche.
 * 
 * @entity Universitat Politècnica de València
 * @author Josep Silva 
 * @version 1 Noviembre 2015
 */

public class Coche extends Vehiculo
{
    private String marca;

    /**
     * Constructor for objects of class Vehículo
     */
    public Coche(double coorX, double coorY, String m)
    {
        super(coorX,coorY);
        this.marca = m;
    }
    
    public double obtenerCoordenadaX(){
        return this.coorX;
    }
    public double obtenerCoordenadaY()
    {
        return this.coorY;
    }
}
