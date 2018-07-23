
/**
 * Clase utilizada para representar un rectángulo.
 * 
 * @entity Universitat Politècnica de València
 * @author Josep Silva 
 * @version 2 Octubre 2012
 */

public class Rectangulo extends Figura
{
    protected double base,altura;

    // Constructor
    public Rectangulo(double cx,double cy, double b, double a)
    {
        super(cx,cy);
        base = b; altura = a;
    }
}
