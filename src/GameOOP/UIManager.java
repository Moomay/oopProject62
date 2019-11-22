/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author Jame
 */
public class UIManager {

    private Handler handler;
    private ArrayList<GameUI> objects;

    public UIManager(Handler handler) {
        this.handler = handler;
        objects = new ArrayList<GameUI>();
    }

    public void tick() {
        for (GameUI o : objects) {
            o.tick();
        }

    }

    public void render(Graphics g) {
        for (GameUI o : objects) {
            o.render(g);
        }

    }

    public void onMouseMove(MouseEvent e) {
        for (GameUI o : objects) {
            o.onMouseMove(e);
        }
    }

    public void onMouseRelease(MouseEvent e) {
        for (GameUI o : objects) {
            o.onMouseRelease(e);
        }
    }

    public void addObject(GameUI o) {
        objects.add(o);
    }

    public void removeObject(GameUI o) {
        objects.remove(o);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<GameUI> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<GameUI> objects) {
        this.objects = objects;
    }
}
