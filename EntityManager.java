/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject62;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Jame
 */
public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        public int compare(Entity a, Entity b) {
            if (a.getY() < b.getY()) {
                return -1;
            }
            return 1;
        }
    };

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }

    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.tick();
            if (!e.isActive()) {
                entities.remove(e);
            }
        }
        entities.sort(renderSorter);

    }

    public void render(Graphics g) {
        for (Entity e : entities) {
            e.render(g);
        }

    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

}
