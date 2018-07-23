

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GrupoFigurasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GrupoFigurasTest_10
{  
    GrupoFiguras g;

    /**
     * Default constructor for test class GrupoFigurasTest
     */
    public GrupoFigurasTest_10()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        g = new GrupoFiguras();
    }
     
    @Test
    public void testVolumen(){
        g.anyadeFigura(new Circulo(10,5,3.5));
        assertEquals(g.volumen(),0, 0);
        g.anyadeFigura(new Triangulo(10,5,6.5,32));
        assertEquals(g.volumen(),0, 0);
        g.anyadeFigura(new Rectangulo(10,5,6.50,320));
        assertEquals(g.volumen(),0, 0);
        g.anyadeFigura(new Cilindro(10,5,6.50,36));
        assertEquals(g.volumen(),4778.362, 0.1);
        g.anyadeFigura(new Circulo(10,5,3.5));
        assertEquals(g.volumen(),4778.362, 0.1);
    }
    
}

