/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
    public static final int DEFAULT_HEALTH = 10;
    protected Handler handler;
    protected GameController game;
    protected float x, y;
    protected float width, height;
    protected Rectangle bounds;
    protected boolean active = true;
    protected int health;
    
    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        health = DEFAULT_HEALTH;
        
        bounds = new Rectangle(0, 0, width, height);
    }
    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for (Entity e : handler.getEntityManager().getEntities()){
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset,yOffset)))
                return true;
        }
        return false;
    }
    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int)(x + bounds.x + xOffset), 
                (int)(y + bounds.y + yOffset),bounds.width, bounds.height);
    }
    public void hurt(int amt){
        health -= amt;
        if (health <= 0){
            active = false;
            die();
        }
    }
    
    public abstract void die();
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public abstract void tick();

    public abstract void render(Graphics g);

}