/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jame
 */
public class ItemManager {
    private Handler handler;
    private ArrayList<Item> items;
    
    public ItemManager(Handler handler){
        this.handler = handler;
        items = new ArrayList<Item>();
    }
    public void tick(){
        Iterator<Item> it = items.iterator();
        while (it.hasNext()){
            Item i = it.next();
            i.tick();
            if (i.isPickedUp()){
               handler.setWord(i.getWord().getWordString());
               handler.setHint(i.getWord().getHint1(), i.getWord().getHint2(), i.getWord().getHint3());
               handler.setUIvisible(true);
               it.remove();
            }
        }
        
    }
    public void render(Graphics g){
        for (Item i : items){
            i.render(g);
        }
    }
    public void addItem(Item i){
        i.setHandler(handler);
        items.add(i);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    
}
