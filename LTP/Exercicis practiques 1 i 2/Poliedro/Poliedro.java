
/**
 * Write a description of class Poliedro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Poliedro extends Figura implements Volumen
{
    protected double arista;
    
    public Poliedro(double x,double y,double arista)
    {
        super(x,y);
        this.arista = arista;
    }
    
    public abstract double area();
    
    public abstract double volumen();
    
    public boolean soyPoliedro(){
        return true;
    }
}
