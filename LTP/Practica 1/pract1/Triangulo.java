
public class Triangulo extends Figura{
    
    private double base,altura;

    Triangulo(double x,double y,double b, double a){
        super(x,y);
        base = b;
        altura = a;
    }
    
    public String toString(){
        return "Triangulo:\n\t"+super.toString()+ "\n\tBase: "+base+"\n\tAltura: "+altura;
    }
    
    public boolean equals(Object o){
        return (o instanceof Triangulo && super.equals(o)
            && this.base == ((Triangulo)o).base
            && this.altura == ((Triangulo)o).altura);
    }
    
    public double area (){
        return base * altura / 2;
    }
}
