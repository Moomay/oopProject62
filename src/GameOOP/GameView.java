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

    private JMenuBar mb1;
    private JMenu m1, m2;
    private JMenuItem mi1, mi2, mi3, mi4, mi5;

    public GameView() {
    }

    public GameView(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void init() {
        // step 1
        f1 = new JFrame("Word of the Death");
        
        /*mb1 = new JMenuBar();
        
        m1 = new JMenu("File");
        m2 = new JMenu("New");
        
        mi1 = new JMenuItem("Open");
        mi2 = new JMenuItem("Save");
        mi3 = new JMenuItem("Exit");
        mi4 = new JMenuItem("Window");
        mi5 = new JMenuItem("Message");
        */
        c1 = new Canvas();
        // step 2
        f1.setSize(width, height);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setBackground(Color.black);
        
        c1.setPreferredSize(new Dimension(width, height));
        c1.setMaximumSize(new Dimension(width, height));
        c1.setMinimumSize(new Dimension(width, height));
        c1.setFocusable(false);

        // step 3
        f1.setJMenuBar(mb1);

        /*mb1.add(m1);

        m1.add(m2);
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);

        m2.add(mi4);
        m2.add(mi5);*/
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

    public JMenuBar getMb1() {
        return mb1;
    }

    public void setMb1(JMenuBar mb1) {
        this.mb1 = mb1;
    }

    public JMenu getM1() {
        return m1;
    }

    public void setM1(JMenu m1) {
        this.m1 = m1;
    }

    public JMenu getM2() {
        return m2;
    }

    public void setM2(JMenu m2) {
        this.m2 = m2;
    }

    public JMenuItem getMi1() {
        return mi1;
    }

    public void setMi1(JMenuItem mi1) {
        this.mi1 = mi1;
    }

    public JMenuItem getMi2() {
        return mi2;
    }

    public void setMi2(JMenuItem mi2) {
        this.mi2 = mi2;
    }

    public JMenuItem getMi3() {
        return mi3;
    }

    public void setMi3(JMenuItem mi3) {
        this.mi3 = mi3;
    }

    public JMenuItem getMi4() {
        return mi4;
    }

    public void setMi4(JMenuItem mi4) {
        this.mi4 = mi4;
    }

    public JMenuItem getMi5() {
        return mi5;
    }

    public void setMi5(JMenuItem mi5) {
        this.mi5 = mi5;
    }

}
