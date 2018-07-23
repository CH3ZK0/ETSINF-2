import java.util.Collection.*;
import java.util.*;

public abstract class Figura<T> implements Desplazamiento {    
    protected double x, y; 
    
    public Figura (double x, double y) {
        this.x = x; 
        this.y = y; 
    }
    public String toString(){
     return "Posicion: ("+x+", "+y+")";}
     
     
    public abstract double area();
    
    public void desplazaX(double c){
        this.x=this.x + c;
    }
    public void desplazaY(double c){
        this.y=this.y + c;
    }
    public void desplazaXY(double c, double d){
        this.x=this.x + c;
        this.y=this.y + d;
    } 
}