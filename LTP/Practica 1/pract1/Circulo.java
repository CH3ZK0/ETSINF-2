
public  class Circulo extends Figura{
    protected double r;
    Circulo(double x, double y, double c) {
        super(x,y);
        r=c;
    }
        
    public String toString (){
        return "Circulo:\n\t"+ super.toString() + "\n\tRadio: "+r;
    }
        
    public boolean equals(Object o){
        return (o instanceof Circulo && super.equals(o)
        && this.r==((Circulo)o).r);
    }
    
    public double area (){
        return Math.pow(r,2)*Math.PI;
    }
}
