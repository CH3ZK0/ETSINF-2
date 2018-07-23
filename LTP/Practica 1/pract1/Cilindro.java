
public class Cilindro extends Circulo implements Volumen{
    protected double a;
    Cilindro(double x, double y, double radio, double altura){
        super(x,y,radio);
        a= altura; 
    }

    Cilindro(Circulo c, double altura){ 
        this(c.x, c.y, c.r, altura);
    }

    public double volumen(){  
        return super.area()*a;
    }   
    
    public double area(){
        Rectangulo rr = new Rectangulo(super.x, super.y, 2*Math.PI*super.r, a);
        double aux = rr.area();
        double res = super.area();
        return aux + res*2;
    }
    
    public double superficie(){
        return area();
    }

}
