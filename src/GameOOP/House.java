/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Jame
 */
public class House extends StaticEntity {

    public House(Handler handler, float x, float y) {
        super(handler, x, y, 500, 1000);

        bounds.x = 20;
        bounds.y = 60;
        bounds.width = 350;
        bounds.height = 300;
    }

    public void die() {

    }

    public void tick() {
    }

    public void render(Graphics g) {
        g.drawImage(Assets.house, (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), 400, 400, null);
        g.setColor(Color.red);
        g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);
    }

}
