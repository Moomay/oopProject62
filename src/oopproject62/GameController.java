/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject62;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Jame
 */
public class GameController implements Runnable, ActionListener {

    private BufferedImage testImage;
    private GameView view;
    private ImageIcon i;
    private Image img;
    
    private Thread thread0;
    private boolean running = false;
    
    private BufferStrategy bs;
    private Graphics g;
    
    public GameController() {

    }

    private void init() {
        view = new GameView(700, 500);
        view.init();
        testImage = ImageLoader.loadImage("test.jpg");
    }

    private void tick() {
    }

    private void render() {
        bs = view.getC1().getBufferStrategy();
        if (bs == null){
            view.getC1().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Claer Screen
        g.clearRect(0,0, 700, 500);
        //Draw
        g.setColor(Color.red);
        g.drawRect(20, 10, 50, 200);
        ImageIcon i = new ImageIcon("test.jpg");
        img = i.getImage();
        g.drawImage(img, 200,300, null);
        g.drawImage(testImage, 1, 1, null);
        //end Drawing
        bs.show();
        g.dispose();
    }

    public void run() {
        init();
        while (running) {
            tick();
            render();
        }
        stop();
    }

    public synchronized void start() {
        running = true;
        thread0 = new Thread(this);
        thread0.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread0.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args) {
        // TODO code application logic here
        GameController game = new GameController();
        game.start();
    }
}
