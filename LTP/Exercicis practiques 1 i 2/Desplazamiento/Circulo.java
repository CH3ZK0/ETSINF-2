public class Circulo extends Figura {
    protected double r;

    public Circulo (double x, double y, double radio) {
        super(x,y);
        r = radio;
    }   
    
    public double area () {
        return Math.PI * Math.pow(r,2);
    }
    
    public String toString(){
        return "Circulo:\n\t"+super.toString()+
                "\n\tRadio: "+r;}
    public boolean equals( Object o){
    return o instanceof Circulo &&
           this.x == ((Circulo)o).x && this.y == ((Circulo)o).y &&
           this.r ==((Circulo)o).r;
    }
 
}