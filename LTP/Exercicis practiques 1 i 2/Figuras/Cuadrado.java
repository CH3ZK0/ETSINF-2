
/**
 * Clase utilizada para representar un cuadrado.
 * 
 * Aprovecha la herencia heredando de rectángulo.
 * 
 * @entity Universitat Politècnica de València
 * @author Josep Silva 
 * @version 12 Octubre 2014
 */

public class Cuadrado extends Rectangulo{

    // Constructor
    public Cuadrado(double cx,double cy, double lado)
    {
        super(cx,cy,lado,lado);
    }
}

