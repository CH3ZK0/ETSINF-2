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
    
    public String toString (){
        return "Triangulo:\n\t"+super.toString()+
               "\n\tBase: "+base+
               "\n\tAltura: "+altura;}
    
    public boolean equals( Object o){
    return o instanceof Triangulo &&
           this.x == ((Triangulo)o).x && this.y == ((Triangulo)o).y &&
           this.base ==((Triangulo)o).base && this.altura == ((Triangulo)o).altura;
    }
}