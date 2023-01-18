/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dibujo;

import java.awt.Graphics;

/**
 *
 * @author jaime
 */
public class Oes1 extends Lineas {

    public Oes1(int x1, int y1, int x2, int y2) {
        super(x1,y1,x2,y2);
    }

    public Oes1() {
    }

    @Override
    public void pintar(Graphics g) {
        g.drawLine(getX1(), getY1(), getX1() - 50, getY1());
    }
    
}
