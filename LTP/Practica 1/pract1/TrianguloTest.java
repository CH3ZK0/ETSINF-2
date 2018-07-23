

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TrianguloTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TrianguloTest
{
    
    Triangulo t1, t2, t3;

    /**
     * Default constructor for test class TrianguloTest
     */
    public TrianguloTest()
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
        t1 = new Triangulo(2,4,5,6);
        t2 = new Triangulo(2,4,5,6);
        t3 = new Triangulo(5,6,2,4);
    }

    
    @Test
    public void testEquals()
    {
        assertTrue(t1.equals(t2));
        assertTrue(t1.equals(t1));
        assertFalse(t1.equals(t3));
        assertFalse(t2.equals(t3));
    }
}
