
/**
 * Clase utilizada para probar el funcionamiento de GrupoFiguras.
 * 
 * @entity Universitat Politècnica de València
 * @author Josep Silva 
 * @version 12 Octubre 2014
 */

public class UsoGrupoFiguras
{
    public static void main (String args[])
    {
        GrupoFiguras g = new GrupoFiguras();

        Cuadrado c1 = new Cuadrado(10,5,2);
        PrismaCuadrangular cc1 = new PrismaCuadrangular(c1,2);
        Circulo ci1 = new Circulo(1.0, 2.0, 5);

        g.anyadeFigura(c1);
        g.anyadeFigura(cc1);
        g.anyadeFigura(ci1);

        System.out.println(g.volumen());        
    }
}
