/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jame
 */
public class UIbotton extends GameUI {

    private BufferedImage images;
    private ClickListener clicker;
    private String word;
    private int index;
    public UIbotton(String word, float x, float y, int width, int height, ClickListener clicker) {
        super(x, y, width, height);
        
        this.clicker = clicker;
        this.word = word;
    }

    @Override
    public void tick() {
        //this.word = 
    }

    @Override
    public void render(Graphics g) {
        if (hovering) {
            g.drawImage(Assets.uiH, (int) x, (int) y, width, height, null);
        } else {
            g.drawImage(Assets.uiB, (int) x, (int) y, width, height, null);

        }

        //g.drawImage(images, (int) x, (int) y, width, height, null);
        Text.drawString(g, word, (int) x + 30, (int) y + 30, true, Color.black, Assets.font28);
    }

    public void onClick() {
        clicker.onClick();
    }

}
