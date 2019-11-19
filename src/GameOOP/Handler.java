/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.util.LinkedList;

/**
 *
 * @author Jame
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jame
 */
public class Handler {

    private GameController game;
    
    private LinkedList <World> worlds;
    public Handler(GameController game) {
        LinkedList<World> object = new LinkedList<World>();
        this.game = game;
    }

    public Handler(GameController game, World world) {
        this.game = game;
        worlds.add(world);
    }
    
    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }

    public KeyManager getKeyManager() {
        return game.getK1();
    }
    public MouseManager getMouseManager(){
        return game.getM1();
    }
    public GameView getView(){
        return game.getView();
    }
    public int getWidth() {
        return game.getWidth();
    }
    public void addWorld(World world){
         worlds.add(world);
    }
    public int getHeight() {
        return game.getHeight();
    }

    public GameController getGame() {
        return game;
    }

    public void setGame(GameController game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    
    public EntityManager getEntityManager(){
        return game.getEntityManager();
    }
    

}
