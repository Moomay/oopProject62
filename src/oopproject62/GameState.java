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
    private World world;
    GameState(GameController game){
        super(game);
        p1 = new Player(game,64,64);
        world = new World("world1.txt");
    }
    public void tick() {
        world.tick();
        p1.tick();
        
    }

    
    public void render(Graphics g) {
        world.render(g);
        p1.render(g);
    }
    
}
