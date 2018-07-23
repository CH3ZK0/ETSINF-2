import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GrupoFigurasTest.
 *
 * @author  (LTPP, ETSINF, DSIC)
 * @version (curs 2014-15)
 */
public class GrupoFigurasTest_2 {
    
    GrupoFiguras g1, g2, g3;

    /**
     * Default constructor for test class GrupoFigurasTest
     */
    public GrupoFigurasTest_2() {
 
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        g1 = new GrupoFiguras();
        g1.anyadeFigura(new Circulo(10,5,3.5));
        g1.anyadeFigura(new Circulo(5,5,3.5));        
        g1.anyadeFigura(new Triangulo(10,5,6.5,32));
        
        g2 = new GrupoFiguras();
        g2.anyadeFigura(new Triangulo(10,5,6.5,32));            
        g2.anyadeFigura(new Circulo(10,5,3.5));
        g2.anyadeFigura(new Circulo(5,5,3.5));   
        
        g3 = new GrupoFiguras();        
        g3.anyadeFigura(new Triangulo(10,5,6.5,32));            
        g3.anyadeFigura(new Circulo(10,5,3.5));
        g3.anyadeFigura(new Circulo(5,5,3.5));
        g3.anyadeFigura(new Triangulo(0,0,6.5,32));               
        
    }

    
    @Test
    public void testEquals() {
        assertTrue(g1.equals(g2));
        assertTrue(g2.equals(g1));
        assertFalse(g1.equals(g3));
        assertFalse(g3.equals(g1));
    }
}
