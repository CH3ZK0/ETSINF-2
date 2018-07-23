

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CirculoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CirculoTest
{
    Circulo c1, c2, c3;
    /**
     * Default constructor for test class CirculoTest
     */
    public CirculoTest()
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
        c1 = new Circulo (2,4,5);
        c2 = new Circulo (2,4,5);
        c3 = new Circulo (3,4,8);
    }

   @Test
    public void testEquals()
    {
        assertTrue(c1.equals(c2));
        assertTrue(c1.equals(c1));
        assertFalse(c1.equals(c3));
        assertFalse(c2.equals(c3));
    }
}
