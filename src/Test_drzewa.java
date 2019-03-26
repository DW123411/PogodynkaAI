

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class Test_drzewa.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Test_drzewa
{
    
    private Drzewo Drzewo;
    private Drzewo Drzewo2;
   
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() throws Exception
    {
     Drzewo = new Drzewo();   
     Wezel<String> korzen = new Wezel<String>(null,"G");
          Drzewo2 = new Drzewo(korzen);   
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
    /**
     *  @DisplayName("Sprawdzamy czy klasa drzewo nie jest nullem")
     */
    @Test
        public void klasa_not_null(){

            assertNotNull(Drzewo);
                        assertNotNull(Drzewo2);
       // fail("not implemented yet");
    
    
    }
    
    @Test
        public void dziecko_null(){
                    
            assertNull(Drzewo.getKorzen());
       // fail("not implemented yet");
    
    
    }
    
     @Test
        public void dziecko_not_null(){
                   
            assertNotNull(Drzewo2.getKorzen());
       // fail("not implemented yet");
    
    
    }
    
    @Test
    public void levelwezla1(){
    assertEquals(Drzewo2.getLevel(Drzewo2.getKorzen()),0);
    
    
    }
}
