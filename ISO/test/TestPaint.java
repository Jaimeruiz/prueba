/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import principal.Lienzo;
import principal.Lineas;

/**
 *
 * @author jaime
 */
public class TestPaint {
    
    public TestPaint() {
    }
    
    @Test
    public void Lineas() {
        Lineas lineas = new Lineas();
    }
    
    @Test 
    public void Lienzo() {
        Lienzo lienzo = new Lienzo();
    }
    
    @Test
    public void array() {
        Lienzo lienzo = new Lienzo();
        Lineas lineas = new Lineas() {};
        ArrayList<Lineas> arrayprueba = new ArrayList<>();
        assertEquals(arrayprueba,lienzo.listarLineas);
        
    }
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
