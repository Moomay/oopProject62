/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author Jame
 */
public class MyClock implements Runnable {

    public Graphics g;

    public MyClock(Graphics g) {
        this.g = g;
    }

    public void run() {
        int sec = 0;
        int min = 0;
        int hour = 0;
        while (true) {
            try {
                sec++;
                if (sec > 59) {
                    min++;
                    sec = 0;
                }
                if (min > 59) {
                    hour++;
                    min = 0;
                }
                Font font = new Font("Courier", Font.BOLD, 50);
                String sec2 = String.format("%02d", sec);
                String min2 = String.format("%02d", min);
                String hour2 = String.format("%02d", hour);
                g.drawString(hour2 + ":" + min2 + ":" + sec2, 500, 500);

                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
