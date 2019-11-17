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
    
    //private Player p1;
    private World world;
    //private Tree tree;
    GameState(Handler handler){
        super(handler);
        
        world = new World(handler,"world1.txt");
        handler.setWorld(world);
        /*p1 = new Player(handler,64,64);
        tree = new Tree(handler, 100, 200);*/
        
    }
    public void tick() {
        world.tick();
        /*p1.tick();
        tree.tick();*/
    }

    
    public void render(Graphics g) {
        world.render(g);
        /*p1.render(g);
        tree.render(g);*/
    }
    
}
