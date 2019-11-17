/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject62;

/**
 *
 * @author Jame
 */
public class GameCamera {
    private GameController game;
    private float xOffset, yOffset;
    public GameCamera(GameController game, float xOffset, float yOffset){
        this.game = game;
        this.yOffset = yOffset;
        this.xOffset = xOffset;
    
    }
    public void centerOnEntity(Entity e){
        xOffset = e.getX() - game.getWidth()/2 + e.getWidth()/2;
        yOffset = e.getY() - game.getHeight()/2 + e.getHeight()/2;
    }
    public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
    }
    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
    
}
