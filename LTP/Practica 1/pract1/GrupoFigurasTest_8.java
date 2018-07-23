

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
public class GrupoFigurasTest_8
{  
    GrupoFiguras g;

    /**
     * Default constructor for test class GrupoFigurasTest
     */
    public GrupoFigurasTest_8()
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
    public void testArea(){
        g.anyadeFigura(new Circulo(10,5,3.5));
        assertEquals(g.area(),38.484, 0.005);
        g.anyadeFigura(new Triangulo(10,5,6.5,32));
        assertEquals(g.area(),142.484, 0.005);
        g.anyadeFigura(new Rectangulo(10,5,6.50,320));
        assertEquals(g.area(),2222.484, 0.005);
        g.anyadeFigura(new Cilindro(10,5,6.50,36));
        // si la superficie de un Cilindro coincide con su area:
        assertEquals(g.area(),3958.2144, 0.005);
        // si la superficie de un Cilindro NO coincide con su area
        // assertEquals(g.area(),2355.216, 0.005);
    }
        
    
}

