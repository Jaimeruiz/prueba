/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
    
     
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUp() throws Exception {
		Tenis2 tenis = new Tenis2();
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
        
     @Test
     public void test1(){
       Tenis2 tenis = new Tenis2();
     }
     
     @Test
     public void breakA() {
         Tenis2 tenis = new Tenis2();
         assertEquals(true,tenis.breakA(4, 1));
         
     }
     
     @Test
     public void breakA2() {
         Tenis2 tenis = new Tenis2();
         assertEquals(false,tenis.breakA(4, 3));
         
     }
     
     @Test
     public void breakA3() {
         Tenis2 tenis = new Tenis2();
         char [] prueba = { 'A', 'B', 'B', 'A', 'A', 'B', 'A', 'A'};
         tenis.setPartido(prueba);
         int A = tenis.puntosA;
         int B = tenis.puntosB;
         assertEquals(true,tenis.breakA(5, 3));
         
     }
     
      @Test
     public void breakB() {
         Tenis2 tenis = new Tenis2();
         char [] prueba = { 'B', 'B', 'B', 'A', 'B',};
         tenis.setPartido(prueba);
         int A = tenis.puntosA;
         int B = tenis.puntosB;
         assertEquals(true,tenis.breakB(0, 4));
         
     }
     
     @Test
     public void breakB2() {
         Tenis2 tenis = new Tenis2();
         assertEquals(false,tenis.breakB(3, 4));
         
     }
     
     @Test
     public void breakB3() {
         Tenis2 tenis = new Tenis2();
         assertEquals(true,tenis.breakB(3, 5));
         
     }
     
     @Test
     public void setA1() {
         Tenis2 tenis = new Tenis2();
         assertEquals(true,tenis.setsA(6, 2));
         
     }
     
     @Test
     public void setA2(){
         Tenis2 tenis = new Tenis2();
         assertEquals(false, tenis.setsA(6, 5));
     }
     
     @Test
     public void setA3(){
         Tenis2 tenis = new Tenis2();
         assertEquals(true, tenis.setsA(7, 5));
     }
     
      @Test
     public void setB1() {
         Tenis2 tenis = new Tenis2();
         assertEquals(true,tenis.setsB(4, 6));
         
     }
     
     @Test
     public void setB2(){
         Tenis2 tenis = new Tenis2();
         assertEquals(false, tenis.setsB(6, 6));
     }
     
     @Test
     public void setB3(){
         Tenis2 tenis = new Tenis2();
         assertEquals(true, tenis.setsB(5, 7));
     }
     
     @Test
     public void tieBreakA(){
         Tenis2 tenis = new Tenis2();
         assertEquals(true, tenis.tieBreakA(7, 4));
     }
     
     @Test
     public void tieBreakB(){
         Tenis2 tenis = new Tenis2();
         assertEquals(true, tenis.tieBreakB(6, 8));
     }
     
     //TEST SOBRE FUNCION RESULTADO 
     
     @Test
     public void partidoAcabadoTresSetsA1() throws Exception {
            Tenis2 tenis = new Tenis2();
            tenis.sets = 3;
            tenis.setA = 2;
            tenis.setB = 1;
            tenis.resultado();
	    assertEquals("PARTIDO TERMINADO\n" + "JUGADOR A gana\n", outContent.toString());
            
	}
	
      @Test
     public void partidoAcabadoTresSetsB1() throws Exception {
            Tenis2 tenis = new Tenis2();
            tenis.sets = 3;
            tenis.setA = 1;
            tenis.setB = 2;
            tenis.resultado();
	    assertEquals("PARTIDO TERMINADO\n" + "JUGADOR B gana\n", outContent.toString());
            
	}
     @Test
     public void partidoAcabadoTresSetsA2() throws Exception {
            Tenis2 tenis = new Tenis2();
            tenis.sets = 3;
            tenis.setA = 2;
            tenis.setB = 0;
            tenis.resultado();
	    assertEquals("PARTIDO TERMINADO\n" + "JUGADOR A gana\n", outContent.toString());
            
	}
	
      @Test
     public void partidoAcabadoTresSetsB2() throws Exception {
            Tenis2 tenis = new Tenis2();
            tenis.sets = 3;
            tenis.setA = 0;
            tenis.setB = 2;
            tenis.resultado();
	    assertEquals("PARTIDO TERMINADO\n" + "JUGADOR B gana\n", outContent.toString());
            
	}
     
      @Test
     public void partidoAcabadoCincoSetsA1() throws Exception {
            Tenis2 tenis = new Tenis2();
            tenis.sets = 5;
            tenis.setA = 3;
            tenis.setB = 0;
            tenis.resultado();
	    assertEquals("PARTIDO TERMINADO\n" + "JUGADOR A gana\n", outContent.toString());
            
	}
	
      @Test
     public void partidoAcabadoCincoSetsB1() throws Exception {
            Tenis2 tenis = new Tenis2();
            tenis.sets = 5;
            tenis.setA = 0;
            tenis.setB = 3;
            tenis.resultado();
	    assertEquals("PARTIDO TERMINADO\n" + "JUGADOR B gana\n", outContent.toString());
            
	}
      @Test
     public void partidoAcabadoCincoSetsA2() throws Exception {
            Tenis2 tenis = new Tenis2();
            tenis.sets = 5;
            tenis.setA = 3;
            tenis.setB = 1;
            tenis.resultado();
	    assertEquals("PARTIDO TERMINADO\n" + "JUGADOR A gana\n", outContent.toString());
            
	}
	
      @Test
     public void partidoAcabadoCincoSetsB2() throws Exception {
            Tenis2 tenis = new Tenis2();
            tenis.sets = 5;
            tenis.setA = 1;
            tenis.setB = 3;
            tenis.resultado();
	    assertEquals("PARTIDO TERMINADO\n" + "JUGADOR B gana\n", outContent.toString());
            
	}
      @Test
     public void partidoAcabadoCincoSetsA3() throws Exception {
            Tenis2 tenis = new Tenis2();
            tenis.sets = 5;
            tenis.setA = 3;
            tenis.setB = 2;
            tenis.resultado();
	    assertEquals("PARTIDO TERMINADO\n" + "JUGADOR A gana\n", outContent.toString());
            
	}
	
      @Test
     public void partidoAcabadoCincoSetsB3() throws Exception {
            Tenis2 tenis = new Tenis2();
            tenis.sets = 5;
            tenis.setA = 2;
            tenis.setB = 3;
            tenis.resultado();
	    assertEquals("PARTIDO TERMINADO\n" + "JUGADOR B gana\n", outContent.toString());
            
	}
     @Test
     public void partidoSinAcabarTresSetsA() throws Exception {
            Tenis2 tenis = new Tenis2();
	    tenis.sets = 3;
            tenis.setA = 1;
            tenis.setB = 0;
            tenis.resultado();
	    assertEquals("PARTIDO EN JUEGO\n", outContent.toString());
	}
     @Test
     public void partidoSinAcabarTresSetsB() throws Exception {
            Tenis2 tenis = new Tenis2();
	    tenis.sets = 3;
            tenis.setA = 0;
            tenis.setB = 1;
            tenis.resultado();
	    assertEquals("PARTIDO EN JUEGO\n", outContent.toString());
	}
     
     
	@Test
     public void partidoSinAcabarCincoSetsA1() throws Exception {
            Tenis2 tenis = new Tenis2();
	    tenis.sets = 5;
            tenis.setA = 2;
            tenis.setB = 0;
            tenis.resultado();
	    assertEquals("PARTIDO EN JUEGO\n", outContent.toString());
	}
     @Test
     public void partidoSinAcabarCincoSetsB1() throws Exception {
            Tenis2 tenis = new Tenis2();
	    tenis.sets = 5;
            tenis.setA = 0;
            tenis.setB = 2;
            tenis.resultado();
	    assertEquals("PARTIDO EN JUEGO\n", outContent.toString());
	}
     @Test
     public void partidoSinAcabarCincoSetsA2() throws Exception {
            Tenis2 tenis = new Tenis2();
	    tenis.sets = 5;
            tenis.setA = 2;
            tenis.setB = 1;
            tenis.resultado();
	    assertEquals("PARTIDO EN JUEGO\n", outContent.toString());
	}
     @Test
     public void partidoSinAcabarCincoSetsB2() throws Exception {
            Tenis2 tenis = new Tenis2();
	    tenis.sets = 5;
            tenis.setA = 1;
            tenis.setB = 2;
            tenis.resultado();
	    assertEquals("PARTIDO EN JUEGO\n", outContent.toString());
	}
     
     
     @Test
     public void partidoMarcadorIncorrecto1() {
	    Tenis2 tenis = new Tenis2();
	    tenis.sets = 3;
            tenis.setA = 4;
            tenis.setB = 0;
            tenis.resultado();
	    assertEquals("RESULTADO INCORRECTO\n", outContent.toString());
		
	}
     @Test
     public void partidoMarcadorIncorrecto2() {
	    Tenis2 tenis = new Tenis2();
	    tenis.sets = 3;
            tenis.setA = 2;
            tenis.setB = 1;
            tenis.breaksA = 1;
            tenis.resultado();
	    assertEquals("RESULTADO INCORRECTO\n", outContent.toString());
		
	}
     @Test
     public void partidoMarcadorIncorrecto3(){
	    Tenis2 tenis = new Tenis2();
	    tenis.sets = 3;
            tenis.setA = 4;
            tenis.setB = 0;
            tenis.puntosB = 1;
            tenis.resultado();
	    assertEquals("RESULTADO INCORRECTO\n", outContent.toString());
		
	}
}
