public abstract class Figura{
    protected double x, y; //Posicion de la figura

    public Figura (double x, double y) {
        this.x = x; this.y = y;
    }
    
    public String toString(){
        return "Posicion: ("+x+", "+y+")";
    }
    
    public boolean equals(Object o){
        return o instanceof Figura 
                && this.x == ((Figura)o).x
                && this.y == ((Figura)o).y ;
    }
    
    abstract double area();
        
    
}
