package librerias.implementacionesDeModelos;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GrupoDeALTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GrupoDeALTest {
    

   GrupoDeAL<Integer> g;
    
    /**
     * Default constructor for test class GrupoDeALTest
     */
    public GrupoDeALTest() { }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        g = new GrupoDeAL<Integer>();
    }  
    
   @Test
   public void testVacioTalla() {   
       assertEquals(g.talla(), 0);
       assertTrue(g.esVacio());    
       
       g.anyade(1);
       g.anyade(12);  
       g.anyade(10); 
       g.anyade(1);
       g.anyade(2);  
       
       assertEquals(g.talla(), 5);
       assertFalse(g.esVacio());         
   }
       
    
   @Test
   public void testAnyadeExiste(){
   
       assertEquals(g.talla(), 0);
       assertTrue(g.esVacio());     
       
       g.anyade(1);
       g.anyade(12);  
       g.anyade(10); 
       g.anyade(1);
       g.anyade(2);  
       
       assertEquals(g.talla(), 5);
       assertFalse(g.esVacio()); 
       
       assertTrue(g.existe(1));
       assertTrue(g.existe(2));
       assertTrue(g.existe(10));
       assertTrue(g.existe(12));
       assertFalse(g.existe(33));
       
   }
    
   @Test
   public void testAnyadeElimina(){    
          
       assertEquals(g.talla(), 0);
       assertTrue(g.esVacio());     
       
       g.anyade(1);
       g.anyade(12);  
       g.anyade(10); 
       g.anyade(1);
       g.anyade(2);      
       
       assertEquals(g.talla(), 5);
       assertFalse(g.esVacio()); 
       
       assertEquals(g.elimina(1),new Integer(1));
       assertEquals(g.talla(), 4);
       
       assertEquals(g.elimina(10),new Integer(10));
       assertEquals(g.talla(), 3);    
       
       assertEquals(g.elimina(1),new Integer(1));
       assertEquals(g.talla(), 2);    

       assertEquals(g.elimina(12),new Integer(12));
       assertEquals(g.talla(), 1);  
       
       assertEquals(g.elimina(33),null);
       assertEquals(g.talla(), 1); 
       
       g.anyade(10); 
       g.anyade(1);       

       assertEquals(g.elimina(2),new Integer(2));
       assertEquals(g.talla(), 2);           
    }
       
          
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() { }
}
