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
    GameState(Handler handler){
        super(handler);
        
        world = new World(handler,"world1.txt");
        handler.setWorld(world);
        p1 = new Player(handler,64,64);
        
    }
    public void tick() {
        world.tick();
        p1.tick();
        handler.getGameCamera().move(1,1);
    }

    
    public void render(Graphics g) {
        world.render(g);
        p1.render(g);
    }
    
}
