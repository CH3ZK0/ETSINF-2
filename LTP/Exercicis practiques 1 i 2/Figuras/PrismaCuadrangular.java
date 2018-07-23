
/**
 * Write a description of class PrismaCuadrangular here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrismaCuadrangular extends Cuadrado implements Volumen
{
    double altura;
    public PrismaCuadrangular(double cx,double cy, double lado, double altura)
    {
        super(cx,cy,lado);
        this.altura = altura;
    }
    
    public PrismaCuadrangular(Cuadrado c,double altura)
    {
        this(c.x, c.y, c.base, altura);
    }
    
    public double volumen(){
        return altura * (super.base * super.base);
    }
}
