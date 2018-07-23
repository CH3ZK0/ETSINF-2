public class Cilindro extends Circulo implements Volumen {
    protected double a;
 
    public Cilindro (double x, double y, double radio, double altura) {
        super(x,y,radio);
        a = altura;
    }

    public double area () {
      double area_base = Math.PI * Math.pow(r,2);
      double perimetro_base = 2 * Math.PI * r;
      return 2 * area_base + perimetro_base * a;
    }

    public double volumen () { 
        double base = Math.PI * Math.pow(r,2);
        return a * base;
    }  
    
    public boolean soyPoliedro() {
        return false;
    }
}
