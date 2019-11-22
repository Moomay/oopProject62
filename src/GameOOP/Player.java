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
    

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, 128, 128);

        bounds.x = 15;
        bounds.y = 35;
        bounds.width = 32;
        bounds.height = 32;

        idle = new BufferedImage[4];
        

        //Animation
       
        
        animNRight = new Animation(100, Assets.playerNew_right);
        animNLeft = new Animation(100, Assets.playerNew_left);
        animNTop = new Animation(100, Assets.playerNew_top);
        animNDown = new Animation(100, Assets.playerNew_down);
        

    }

    public void tick() {
        //animation
        
        animNRight.tick();
        animNLeft.tick();
        animNTop.tick();
        animNDown.tick();
        //move
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

        
        
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

    @Override
    public void die() {
       
    }


    

}
