
public class Rectangulo extends Figura{
    
    private double base,altura;

    Rectangulo(double x,double y,double b, double a){
        super(x,y);
        base = b;
        altura = a;
    }
    
    public String toString(){
        return "Rectangulo:\n\t"+super.toString()+ "\n\tBase: "+base+"\n\tAltura: "+altura;
    }
    
    public boolean equals(Object o){
        return (o instanceof Rectangulo && super.equals(o)
            && this.base == ((Rectangulo)o).base
            && this.altura == ((Rectangulo)o).altura);
    }
    
    public double area (){
        return base * altura;
    }
}
