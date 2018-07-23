public abstract class Figura {    
    protected double x, y; 
    
    public Figura (double x, double y) {
        this.x = x; 
        this.y = y; 
    }
    
    public abstract double area();
}