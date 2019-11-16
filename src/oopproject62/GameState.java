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
public class GameState extends State{
    
    private Player p1;
    
    GameState(GameController game){
        super(game);
        p1 = new Player(game,100,100);
    }
    public void tick() {
        p1.tick();
    }

    
    public void render(Graphics g) {
        p1.render(g);
    }
    
}
