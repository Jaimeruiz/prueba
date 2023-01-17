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
    
    JToggleButton Lap, Arr, Abj;
    JButton nor1, sur1, est1, oes1;
    
    public ArrayList<Lineas> listarLineas = null;

    public Lienzo() {
        setListarLineas(new ArrayList<>());
    }

    
    
    
    
    
    public ArrayList<Lineas> getListarLineas() {
        return listarLineas;
    }

    public void setListarLineas(ArrayList<Lineas> listarLineas) {
        this.listarLineas = listarLineas;
    }
    
}
