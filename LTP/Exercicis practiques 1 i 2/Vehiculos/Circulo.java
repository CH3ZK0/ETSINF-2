
/**
 * Clase utilizada para representar un círculo.
 * 
 * @entity Universitat Politècnica de València
 * @author Josep Silva 
 * @version 2 Octubre 2012
 */

public class Circulo extends Figura
{
    protected double radio;

    // Constructor
    public Circulo(double a, double b, double c)
    {
        super(a,b);
        radio=c;
    }
}
