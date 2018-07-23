package librerias.implementacionesDeModelos;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ColaACTest
{
    

    ColaAC<Integer> cola;
    
    /**
     * Default constructor for test class ColaACTest
     */
    public ColaACTest()
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
        cola = new ColaAC<Integer>();
    }  
    
    @Test
    public void testPrimero(){
       assertEquals(cola.talla(), 0);
       for (int i=0; i < 15; i++){
            cola.encolar(new Integer(i));
            assertEquals(cola.primero(), new Integer(0));
       }
    }
    
    
    @Test
    public void testEsVacia(){
    
       assertEquals(cola.talla(), 0);
       assertTrue(cola.esVacia());
       cola.encolar(new Integer(1));
       assertEquals(cola.talla(), 1);
       assertFalse(cola.esVacia());
       cola.encolar(new Integer(2));
       assertFalse(cola.esVacia());
       cola.desencolar(); cola.desencolar();
       assertTrue(cola.esVacia());
       assertEquals(cola.talla(), 0);
    }
    
    
    @Test
    public void testSimple(){
       assertEquals(cola.talla(), 0);
       cola.encolar(new Integer(1));
       assertEquals(cola.talla(), 1);
       assertEquals(cola.primero(), new Integer(1));
       cola.encolar(new Integer(2));
       assertEquals(cola.talla(), 2);
       assertEquals(cola.primero(), new Integer(1));
       assertEquals(cola.desencolar(), new Integer(1));
       assertEquals(cola.desencolar(), new Integer(2));
       assertEquals(cola.talla(), 0);      
    }
    
    @Test
    public void testEncolar(){
    
       assertEquals(cola.talla(), 0);
       // sabemos que el Max es 10, asi que encolamos 15 elementos
       for (int i=0; i < 15; i++) cola.encolar(new Integer(i));
       assertEquals(cola.talla(), 15);
       assertEquals(cola.desencolar(), new Integer(0));
       assertEquals(cola.desencolar(), new Integer(1));
       assertEquals(cola.desencolar(), new Integer(2));
       assertEquals(cola.desencolar(), new Integer(3));
       assertEquals(cola.desencolar(), new Integer(4));
       assertEquals(cola.desencolar(), new Integer(5));
       assertEquals(cola.desencolar(), new Integer(6));
       assertEquals(cola.desencolar(), new Integer(7));
       assertEquals(cola.desencolar(), new Integer(8));
       assertEquals(cola.desencolar(), new Integer(9));
       assertEquals(cola.desencolar(), new Integer(10));
       assertEquals(cola.desencolar(), new Integer(11));
       assertEquals(cola.desencolar(), new Integer(12));
       assertEquals(cola.desencolar(), new Integer(13));
       assertEquals(cola.desencolar(), new Integer(14));
       assertEquals(cola.talla(), 0);
         
    }
    
    @Test
    public void testDesencolar(){
       for (int i=0; i < 15; i++) cola.encolar(new Integer(i));
       for (int i=0; i < 15; i++){
            assertEquals(cola.desencolar(), new Integer(i));
       }
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        
    }
}
