/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jame
 */
public class Player extends Creature {

    private Animation animRight;
    private Animation animRight0;
    private Animation animLeft;
    private Animation animDown;
    private Animation animTop;
    
    private Animation animNRight;
    private Animation animNLeft;
    private Animation animNDown;
    private Animation animNTop;
    private BufferedImage[] idle;
    private int stage = 0;
    private boolean hovering = false;
    
    private Inventory inventory;
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, 128, 128);

        bounds.x = 15;
        bounds.y = 35;
        bounds.width = 32;
        bounds.height = 32;

        idle = new BufferedImage[4];
        idle = Assets.player_idle;

        //Animation
        animRight = new Animation(100, Assets.player_right);
        animRight0 = new Animation(100, Assets.player_right0);
        animLeft = new Animation(100, Assets.player_left);
        animTop = new Animation(100, Assets.player_top);
        animDown = new Animation(100, Assets.player_down);
        
        
        animNRight = new Animation(100, Assets.playerNew_right);
        animNLeft = new Animation(100, Assets.playerNew_left);
        animNTop = new Animation(100, Assets.playerNew_top);
        animNDown = new Animation(100, Assets.playerNew_down);
        
        inventory = new Inventory(handler);
    }

    public void tick() {
        //animation
        animRight0.tick();
        animLeft.tick();
        animTop.tick();
        animDown.tick();
        
        animNRight.tick();
        animNLeft.tick();
        animNTop.tick();
        animNDown.tick();
        //move
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        //atk
        //checkAttacks();
        //inventory
        inventory.tick();
        
        
    }
   
   
    /*
    public void checkAttacks() {
        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;
        if (handler.getKeyManager().aUp) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
            System.out.println(" "+x+"      "+y);
        } else if (handler.getKeyManager().aDown) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        } else if (handler.getKeyManager().aLeft) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else if (handler.getKeyManager().aRight) {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else {
            return;
        }
        for (Entity e : handler.getEntityManager().getEntities()) {
            if (e.equals(this)) {
                continue;
            }
            if (e.getCollisionBounds(0, 0).intersects(ar)) {
                e.hurt(1);
                return;
            }
        }

    }*/

    public void die() {
        System.out.println("U lose");
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;
        float speed1 = (float) (speed*Math.sqrt(2)/2);
        
        if (handler.getKeyManager().up ) {
            yMove = -speed;
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }
        if (handler.getKeyManager().up && handler.getKeyManager().left) {
            
            yMove = -speed1;
            xMove = -speed1;
        }
        if (handler.getKeyManager().up && handler.getKeyManager().right) {
            yMove = -speed1;
            xMove = speed1;
        }
        if (handler.getKeyManager().down && handler.getKeyManager().left) {
            yMove = speed1;
             xMove = -speed1;
        }
        if (handler.getKeyManager().down && handler.getKeyManager().right) {
            yMove = speed1;
             xMove = speed1;
        }

    }

    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), 64, 64, null);
        /*g.setColor(Color.red);
        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);
        */
    }
    public void postRender(Graphics g){
        inventory.render(g);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            stage = 1;
            return animNLeft.getCurrentFrame();
        } else if (xMove > 0) {
            stage = 0;
            return animNRight.getCurrentFrame();
        } else if (yMove < 0) {
            stage = 3;
            return animNTop.getCurrentFrame();
        } else if (yMove > 0) {
            stage = 2;
            return animNDown.getCurrentFrame();
        } else {
            return Assets.playerNew_idle[stage];
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
    

}
