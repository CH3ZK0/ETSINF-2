
/**
 * Write a description of class Hexaedro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hexaedro extends Poliedro
{
    public Hexaedro(double x,double y,double arista)
    {
       super(x,y, arista);
    }
    
    public double area(){
        return Math.pow(arista,2)*6;
    }
    
    public double volumen(){
        return Math.pow(arista,3);
    }
}
