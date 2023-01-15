/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import dibujo.Lineas;
import dibujo.Lienzo;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author jaime
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(pantalla.getWidth());
        System.out.println(pantalla.getHeight());
        JFrame ventana = new JFrame();
        Lienzo lienzo = new Lienzo();
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setSize(600,600);
        ventana.getContentPane().add(lienzo);  
        ventana.setVisible(true);
        
    }
    
}
