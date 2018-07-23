
/**
 * Clase utilizada para probar el funcionamiento de Comparador.
 * 
 * @entity Universitat Politècnica de València
 * @author Josep Silva 
 * @version 1 Noviembre 2015
 */

public class UsoComparador
{
    public static void main (String args[])
    {
        Vehiculo co1 = new Coche(1,1,"Nissan");
        Vehiculo co2 = new Coche(1,1,"Ford");

        Comparador<Vehiculo> com1; 
        com1 = new Comparador<Vehiculo>(co1,co2);
        System.out.println(com1.compararPosiciones());

        Figura cir1 = new Circulo(1,2,3);
        Figura rec1 = new Rectangulo(1,1,3,5);

        Comparador<Figura> com2; 
        com2 = new Comparador<Figura>(cir1,rec1);
        System.out.println(com2.compararPosiciones());
    }
}
