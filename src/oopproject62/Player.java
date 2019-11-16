/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject62;

import java.awt.Graphics;

/**
 *
 * @author Jame
 */
public class Player extends Creature {

    private GameController game;

    public Player(GameController game, float x, float y) {
        super(x, y, 64,64);
        this.game = game;
    }

    public void tick() {
        getInput();
        move();
    }
    private void getInput(){
        xMove = 0;
        yMove = 0;
        if(game.getKeyManager().up)
            yMove = -speed;
        if(game.getKeyManager().down)
            yMove = speed;
        if(game.getKeyManager().left)
            xMove = -speed;
        if(game.getKeyManager().right)
            xMove = speed;
    }
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y,64, 64, null);
    }

}
