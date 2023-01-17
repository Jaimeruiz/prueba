/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

/**
 *
 * @author jaime
 */
public class Lineas {
  
  Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
  private int x1 = pantalla.width, y1 = pantalla.height, x2 = x1, y2 = y1;

    public Lineas(int x1, int y1, int x2, int y2) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
    }
  
   public void pintar(Graphics grafico){
       grafico.drawLine(getX1(), getY1(), getX2(), getY2());
   }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
  
  
}

