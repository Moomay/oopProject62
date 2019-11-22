/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import com.sun.glass.events.KeyEvent;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Jame
 */
public class Inventory {
    private Handler handler;
    private boolean active  = false;
    private ArrayList<Item> inventoryItems;
    private int inX,inY,inWidth,inHeight;
    public Inventory(Handler handler){
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();
        inX = 20;
        inY = 400;
        inWidth = 600;
        inHeight = 240;
    }
    void tick(){
        /*if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
            active =!active;
        if(!active)
            return;
        */
        
    }
    public void render(Graphics g){
       /* if(!active)
            return;
        g.drawImage(Assets.inventory, inX, inY, inWidth, inHeight, null);*/
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    /*public void addItem(Item item){
        for(Item i : inventoryItems){
            if (i.getId() == item.getId()){
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }*/
    
    
}
