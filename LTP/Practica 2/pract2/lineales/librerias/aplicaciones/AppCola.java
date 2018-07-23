package librerias.aplicaciones;

import librerias.implementacionesDeModelos.*;
import librerias.modelos.*;

/**
 * @author (Professors LTPP) 
 */

public class AppCola {
    public static void main (String args[])throws Exception
    {Cola<Integer> c = new ColaAC <Integer>();
     for (int i = 1; i <= 15;i++)
        c.encolar(i);
        
     System.out.println("Cola inicial:\n"+c);
     int cantidadEliminada = 10;
     for (int i = 0; i <cantidadEliminada ;i++)
        c.desencolar();
     System.out.println("Cola despues de desencolar "+cantidadEliminada+":\n"+c);
     int catidadEncolada = 25;
     for (int i = 1; i <=catidadEncolada;i++)
        c.encolar(i);
     System.out.println("Cola despues de encolar "+catidadEncolada+":\n"+c);   
    }
}
