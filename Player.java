/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject62;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
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
    private BufferedImage[] idle;
    private int stage = 0;
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, 64, 64);

        bounds.x = 50;
        bounds.y = 70;
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
    }

    public void tick() {
        //animation
        animRight0.tick();
        animLeft.tick();
        animTop.tick();
        animDown.tick();
        //move
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        //atk
        checkAttacks();
    }

    public void checkAttacks() {
        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;
        if (handler.getKeyManager().aUp) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        } else if (handler.getKeyManager().aDown) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        } else if (handler.getKeyManager().aLeft) {
            ar.x = cb.x - arSize;
            ar.y = cb.y - cb.height/2 - arSize/2;
        } else if (handler.getKeyManager().aRight) {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height/2 -arSize/2;
        } else{
            return;
        }
        for (Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }
            if (e.getCollisionBounds(0,0).intersects(ar)){
                e.hurt(1);
                return;
            }
        }

    }

    public void die() {
        System.out.println("U lose");
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;
        if (handler.getKeyManager().up) {
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

    }

    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), 128, 128, null);
        /*g.setColor(Color.red);
        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);*/
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            stage = 1;
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            stage = 0;
            return animRight0.getCurrentFrame();
        } else if (yMove < 0) {
            stage = 2;
            return animDown.getCurrentFrame();
        } else if (yMove > 0) {
            stage = 3;
            return animTop.getCurrentFrame();
        } else {
            return Assets.player_idle[stage];
        }
    }

}
