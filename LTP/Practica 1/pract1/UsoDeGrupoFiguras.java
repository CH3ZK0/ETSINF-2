
public class UsoDeGrupoFiguras{
    public static void main (String args[]){
        GrupoFiguras g =new GrupoFiguras();
        g.anyadeCirculo(new Circulo(10,5,3.5));
        g.anyadeCirculo(new Circulo(11,6,4));
        g.anyadeTriangulo(new Triangulo(10,5,6.5,32));
        g.anyadeTriangulo(new Triangulo(12,6,6.5,56));
        g.anyadeRectangulo(new Rectangulo(12,34,23,1));
        g.anyadeRectangulo(new Rectangulo(12,35,23,2));
        System.out.println(g);
    }
}
