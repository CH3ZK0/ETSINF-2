public class UsoGrupoFiguras {    
    public static void main (String args[]) {
        GrupoFiguras <Figura>g1 = new GrupoFiguras<Figura>();
        g1.anyadeFigura(new Circulo(2,3,5));
        g1.anyadeFigura(new Triangulo(6,7,2,3));
        g1.anyadeFigura(new Triangulo(6,7,2,3));
        System.out.println("Area = "+g1.area());
        System.out.println(g1);
        g1.desplazaXY(1,-1);
        System.out.println("\n"+g1);
        GrupoFiguras <Figura>g2 = new GrupoFiguras<Figura>();
        g1.anyadeFigura(new Circulo(-2,-3,5));
        g1.anyadeFigura(new Triangulo(-6,-7,2,3));
        g1.unir(g2);
        System.out.println("\n"+g1);

    }
}