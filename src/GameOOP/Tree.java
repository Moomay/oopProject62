/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.Color;
import java.awt.Graphics;


public class Tree extends StaticEntity {

    public Tree(Handler handler, float x, float y) {
        super(handler, x, y,0, 0);

        bounds.x = 50;
        bounds.y = 66;
        bounds.width = 24;
        bounds.height = 40;
    }

    @Override
    public void die(){
        
    }
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()),120,140,null);
        g.setColor(Color.red);
        /*g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);*/
    }

}
