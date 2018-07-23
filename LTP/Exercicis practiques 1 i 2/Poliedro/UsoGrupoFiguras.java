public class UsoGrupoFiguras {    
    public static void main (String args[]) {
        GrupoFiguras g = new GrupoFiguras();
        Figura c = new Circulo(2,3,5);
        Figura t = new Triangulo(6,7,2,3);
        Figura ci = new Cilindro(2,4,7,5);
        Poliedro tt = new Tetraedro(2,3,9);
        Poliedro hx = new Hexaedro(7,8,5);
        g.anyadeFigura(c);
        g.anyadeFigura(t);
        g.anyadeFigura(ci);
        g.anyadeFigura(tt);
        g.anyadeFigura(hx);
        System.out.println("Area = "+g.area());
        System.out.println("Volumen = "+g.volumen());
    }
}