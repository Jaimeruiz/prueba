/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dibujo.Lienzo;
import dibujo.Lineas;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaime
 */
public class testLineas {
    
    public testLineas() {
       
    }
    
    @Test
    public void linea() {
        Lineas linea = new Lineas(200,200,200,150) {};
        assertNotNull(linea);
        
    }
    
     @Test
    public void array(){
        Lienzo lienzo = new Lienzo();
        Lineas linea = new Lineas() {};
        ArrayList<Lienzo> array = new ArrayList<>();
        assertEquals(array,lienzo.listarCirculos);
        //Test que comprueba que el arrayList creado no es nulo y se inicializa para guardar en el eltos.
    }
    
    @Test 
    public void pintarNor1() {
        Lienzo lienzo = new Lienzo();
        Lineas linea = new Lineas() {};
        assertEquals(linea.getY2() - 50,lienzo.crearNorte());
        //Test que comprueba el resultado de ejecutar el metodo de crear lineas
        assertEquals(1,lienzo.getListarCirculos().size());
       //---------------------------------------//
       lienzo.crearNorte();
       assertEquals(2,lienzo.getListarCirculos().size());
       assertEquals(lienzo.getListarCirculos().get(1).getY2(), linea.getY2() - 100);
      
    }
   
  
    

    
    @Test 
    public void pintarSur1() {
       Lienzo lienzo = new Lienzo();
       Lineas linea = new Lineas() {};
       assertEquals(linea.getY2() + 50,lienzo.crearSur());
       
       //--------------------------------------//
       assertEquals(1,lienzo.getListarCirculos().size());
       //---------------------------------------//
       lienzo.crearNorte();
       assertEquals(2,lienzo.getListarCirculos().size());
       assertEquals(lienzo.getListarCirculos().get(1).getY2(), linea.getY2());
       
     //Tests metodos definitivo  
    }
    
    @Test
    public void pintarEst1() {
        Lienzo lienzo = new Lienzo();
        Lineas linea = new Lineas() {};
        assertEquals(linea.getX2() + 50, lienzo.crearEste());
        //------------------------------------//
        assertEquals(1,lienzo.getListarCirculos().size());
        //-----------------------------------------------//
        lienzo.crearSur();
        lienzo.crearEste();
        assertEquals(3,lienzo.getListarCirculos().size());
        assertEquals(lienzo.getListarCirculos().get(2).getY2(), linea.getY2() + 50);
        assertEquals(lienzo.getListarCirculos().get(2).getX2(), linea.getX2() + 100);
        
    }
    
    @Test
    public void pintarOes1() {
        Lienzo lienzo = new Lienzo();
        Lineas linea = new Lineas() {};
        assertEquals(linea.getX2() - 50, lienzo.crearOeste());
        //------------------------------------//
        assertEquals(1,lienzo.getListarCirculos().size());
        //-----------------------------------------------//
        lienzo.crearNorte();
        lienzo.crearEste();
        lienzo.crearSur();
        assertEquals(4,lienzo.getListarCirculos().size());
        assertEquals(lienzo.getListarCirculos().get(3).getY2(), linea.getY2());
        assertEquals(lienzo.getListarCirculos().get(3).getX2(), linea.getX2());
    }
    
    
     
    
    @Test 
    public void moverNor1() {
        Lienzo lienzo = new Lienzo();
        Lineas linea = new Lineas() {};
        assertEquals(linea.getY2() - 50, lienzo.desplazarNorte());
        //-------------------------------------------------------//
        lienzo.crearNorte();
        assertEquals(lienzo.getListarCirculos().size(),1);
        assertEquals(lienzo.getListarCirculos().get(0).getY2(), linea.getY2() - 100);
    }
    
    @Test 
    public void moverSur1() {
        Lienzo lienzo = new Lienzo();
        Lineas linea = new Lineas() {};
        assertEquals(linea.getY2() + 50, lienzo.desplazarSur());
        //-------------------------------------------------------//
        lienzo.desplazarSur();
        lienzo.crearEste();
        assertEquals(lienzo.getListarCirculos().size(),1);
        assertEquals(lienzo.getListarCirculos().get(0).getX2(), linea.getX2() + 50);
        assertEquals(lienzo.getListarCirculos().get(0).getY2(), linea.getY2() + 100);
    }
    
     @Test 
    public void moverEst1() {
        Lienzo lienzo = new Lienzo();
        Lineas linea = new Lineas() {};
        assertEquals(linea.getX2() + 50, lienzo.desplazarEste());
        //-------------------------------------------------------//
        lienzo.desplazarNorte();
        lienzo.desplazarEste();
        lienzo.crearEste();
        assertEquals(lienzo.getListarCirculos().size(),1);
        assertEquals(lienzo.getListarCirculos().get(0).getY2(), linea.getY2() - 50);
        assertEquals(lienzo.getListarCirculos().get(0).getX2(), linea.getX2() + 150);
    }
    
    @Test 
    public void moverOes1() {
        Lienzo lienzo = new Lienzo();
        Lineas linea = new Lineas() {};
        assertEquals(linea.getX2() - 50, lienzo.desplazarOeste());
        //-------------------------------------------------------//
        lienzo.crearSur();
        lienzo.desplazarEste();
        lienzo.crearNorte();
        assertEquals(lienzo.getListarCirculos().size(),2);
        assertEquals(lienzo.getListarCirculos().get(1).getY2(), linea.getY2());
        assertEquals(lienzo.getListarCirculos().get(1).getX2(), linea.getX2());
    }
    
}
