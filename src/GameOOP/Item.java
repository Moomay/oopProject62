/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jame
 */
public class Item {

    public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
    public static Item[] item = new Item[256];
    public static Item boxItem = new Item(Assets.box, "box", Word.w1);
    
    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    //protected final int id;
    
    protected Rectangle bounds;
    protected int x, y, count;
    private String [] hint;
    private String [] setofword;
    private Word word;
    protected boolean pickedUp = false;
    public Item(BufferedImage texture, String name,Word word) {
        this.texture = texture;
        this.name = name;
        this.word = word;
        count = 1;
        bounds = new Rectangle(x,y,ITEMWIDTH, ITEMHEIGHT);
    }

    public void tick() {
        if (handler.getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)){
            pickedUp = true;
            //handler.getEntityManager().getPlayer().getInventory().addItem(this);
        }
    }

    public void render(Graphics g) {
        if (handler == null){
            return;
        }
        render(g, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()));
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
    }
    public Item createNew(int x,int y){
        Item i = new Item(texture, name, word);
        i.setPosition(x,y);
        return i;
    }
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
        bounds.x = x;
        bounds.y = y;
    }
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public Word getWord() {
        return word;
    }

    

    
    
    
}
