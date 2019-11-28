/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class GameView extends JPanel {

    private int width, height;
    private JFrame f1;
    private Canvas c1;

   

    public GameView() {
    }

    public GameView(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void init() {
        // step 1
        f1 = new JFrame("Word of the Death");
        
        c1 = new Canvas();
        // step 2
        f1.setSize(width, height);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setBackground(Color.black);
        f1.setResizable(false);
        
        c1.setPreferredSize(new Dimension(width, height));
        c1.setMaximumSize(new Dimension(width, height));
        c1.setMinimumSize(new Dimension(width, height));
        c1.setFocusable(false);

        // step 3
        


        f1.add(c1);
        f1.getContentPane().setBackground(Color.black);
        f1.pack();
    }

    public Canvas getC1() {
        return c1;
    }

    public void setC1(Canvas c1) {
        this.c1 = c1;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public JFrame getF1() {
        return f1;
    }

    public void setF1(JFrame f1) {
        this.f1 = f1;
    }

}
