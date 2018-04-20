/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.caterpillar.anasrevenge.nucleo.hilos;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author jesus
 */
public class Hilo extends Thread{
    ImageIcon imagen;
    JPanel panel;
    Graphics g;
    
    public Hilo(JPanel panel, ImageIcon imagen){
        super();
        this.panel = panel;
        this.imagen = imagen;
        this.g = this.panel.getGraphics();
    }
    
    public synchronized void colocarImagen(){
        g.drawImage(imagen.getImage(), 0, 0, 250, 250, panel);
    }
    
    public void start(){
        colocarImagen();
    }
}
