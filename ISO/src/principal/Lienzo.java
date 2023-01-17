/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author jaime
 */
public class Lienzo extends JPanel {
    Lineas lineas = new Lineas();
    JToggleButton Lap, Arr, Abj;
    JButton nor1, sur1, est1, oes1;
    
    public ArrayList<Lineas> listarLineas = null;

    public Lienzo() {
        setListarLineas(new ArrayList<>());
    }

    public int dibujarNor1(){
        getListarLineas().add(new Lineas(lineas.getX1(), lineas.getY1(),lineas.getX1(), lineas.getY1() - 50));
        lineas.setY1(lineas.getY1() - 50);
        return lineas.getY1();
    }
    
    
    
    
    public ArrayList<Lineas> getListarLineas() {
        return listarLineas;
    }

    public void setListarLineas(ArrayList<Lineas> listarLineas) {
        this.listarLineas = listarLineas;
    }
    
}
