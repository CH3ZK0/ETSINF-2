
/**
 * Clase utilizada para representar una figura geométrica.
 * 
 * @entity Universitat Politècnica de València
 * @author Josep Silva 
 * @version 2 Octubre 2012
 */

abstract class Figura
{
    protected double x, y; //Posición de la figura

    public Figura (double x, double y)
    {
        this.x = x; 
        this.y = y;
    }
}
