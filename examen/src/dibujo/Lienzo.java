/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dibujo;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author jaime
 */

public class Lienzo extends JPanel implements ActionListener {
  Lineas linea = new Lineas() {};
  public JButton botonNor, botonSur, botonEst, botonOes;
  public JToggleButton botonLap,botonAbj, botonArr;
  public ArrayList<Lineas> listarCirculos = null;
 
  
    public Lienzo() {
        botones();
        setListarCirculos(new ArrayList<>());
        addActionListener(this);
        
        
    }
    
    public void botones() {
        
        botonLap = new JToggleButton("LAP");
        botonLap.setBounds(200, 100, 100, 40);
        botonLap.addActionListener(this);
        Lienzo.this.add(botonLap);
        
        botonArr = new JToggleButton("ARR");
        botonArr.setBounds(200, 100, 100, 40);
        botonArr.addActionListener(this);
        Lienzo.this.add(botonArr);
        
        botonAbj = new JToggleButton("ABJ");
        botonAbj.setBounds(200, 100, 100, 40);
        botonAbj.addActionListener(this);
        Lienzo.this.add(botonAbj);
        
        botonNor = new JButton("NOR1");
        botonNor.setBounds(200, 100, 100, 40);
        botonNor.addActionListener(this);
        Lienzo.this.add(botonNor);
        
        botonSur = new JButton("SUR1");
        botonSur.setBounds(200, 100, 100, 40);
        botonSur.addActionListener(this);
        Lienzo.this.add(botonSur);
        
        botonEst = new JButton("EST1");
        botonEst.setBounds(200, 100, 100, 40);
        botonEst.addActionListener(this);
        Lienzo.this.add(botonEst);
        
        botonOes = new JButton("OES1");
        botonOes.setBounds(200, 100, 100, 40);
        botonOes.addActionListener(this);
        Lienzo.this.add(botonOes);

    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Lineas objCirculo : getListarCirculos()) {
            objCirculo.pintar(g);
        }
    }
    
    public int desplazarNorte() {
        linea.setY1(linea.getY1() - 50);
        return linea.getY1();
    }
    
    public int desplazarSur() {
        linea.setY1(linea.getY1() + 50);
        return linea.getY1();
    }
    
    public int desplazarEste() {
        linea.setX1(linea.getX1() + 50);
        return linea.getX1();
    }
    
    public int desplazarOeste() {
        linea.setX1(linea.getX1() - 50);
        return linea.getX1();
    }
    
    
    public int crearNorte(){
           getListarCirculos().add(new Nor1(linea.getX1(), linea.getY1(), linea.getX1(), linea.getY1() - 50));
            repaint();
            linea.setY1(linea.getY1() - 50);
            return linea.getY1();
            //norte();
    }
   
   
    public int crearSur() {
            getListarCirculos().add(new Sur1(linea.getX1(), linea.getY1(), linea.getX1(), linea.getY1() + 50));
            repaint();
            linea.setY1(linea.getY1() + 50);
            return linea.getY1();
            //sur();
    }
    
    public int crearEste() {
            getListarCirculos().add(new Est1(linea.getX1(), linea.getY1(), linea.getX1() + 50, linea.getY1()));
            repaint();
            linea.setX1(linea.getX1() + 50);
            return linea.getX1();
            //este();
    }
    
    public int crearOeste() {
            getListarCirculos().add(new Oes1(linea.getX1(), linea.getY1(), linea.getX1() - 50, linea.getY1()));
            repaint();
            linea.setX1(linea.getX1() - 50);
            return linea.getX1();
            //oeste();
    }
    
    
public ArrayList<Lineas> getListarCirculos() {
        return listarCirculos;
    }

    public void setListarCirculos(ArrayList<Lineas> listarCirculos) {
        this.listarCirculos = listarCirculos;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
     if( botonLap.isSelected()) { 
       if(botonAbj.isSelected()) {  
         if(e.getSource() == botonNor) {
           crearNorte();
      }
         else if(e.getSource() == botonSur) {
           crearSur();
      }
         else if(e.getSource() == botonEst) {
           crearEste();
      }
         else if(e.getSource() == botonOes) {
           crearOeste();
      }
     }
       
     else {
           if(e.getSource() == botonNor) {
           desplazarNorte();
      }
         else if(e.getSource() == botonSur) {
           desplazarSur();
      }
         else if(e.getSource() == botonEst) {
           desplazarEste();
      }
         else if(e.getSource() == botonOes) {
           desplazarOeste();
      }
       }
    }
    else {
         System.out.println("Seleccione el lapiz para dibujar");
     }
    }
}
