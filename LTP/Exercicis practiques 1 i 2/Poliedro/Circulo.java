public class Circulo extends Figura {
    protected double r;

    public Circulo (double x, double y, double radio) {
        super(x,y);
        r = radio;
    }   
    
    public double area () {
        return Math.PI * Math.pow(r,2);
    }
}