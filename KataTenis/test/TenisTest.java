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
import principal.Tenis2;

/**
 *
 * @author Jaime
 */
public class TenisTest {
    
    public TenisTest() {
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

     
        @Test
     public void test1(){
       Tenis2 tenis = new Tenis2();
     }
     
     @Test
     public void array(){
       Tenis2 tenis = new Tenis2();
       ArrayList<Character> prueba = new ArrayList<>();
       prueba.add('A');
       tenis.getPartido().add('A');
       assertEquals(prueba, tenis.getPartido());
     }
       
     
     
}
