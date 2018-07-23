public class Triangulo extends Figura { 
    private double base, altura;

    public Triangulo (double x, double y, double base, double altura) { 
        super(x,y); 
        this.base = base; 
        this.altura = altura;
    } 
    
    public double area () {
        return base * altura / 2;
    }
}