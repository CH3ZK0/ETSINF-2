
/**
 * Write a description of class Tetraedro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tetraedro extends Poliedro
{
    public Tetraedro(double x,double y,double arista)
    {
       super(x,y, arista);
    }
    
    public double area(){
        
        return Math.pow(arista,2)*(Math.sqrt(3));
    }
    
    public double volumen(){
        
        return Math.pow(arista,3)*(Math.sqrt(2)/12);
    }
}
