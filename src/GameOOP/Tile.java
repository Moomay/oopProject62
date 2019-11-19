/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


/**
 *
 * @author Jame
 */
public class Tile {
    //static stuff here
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile watterTile = new WatterTile(2);
    public static Tile grass24Tile = new Grass24Tile(24);
    public static Tile grass25Tile = new Grass25Tile(25);
    public static Tile grass26Tile = new Grass26Tile(26);
    public static Tile grass27Tile = new Grass27Tile(26);
    
    //class
    public static final int TILEWIDTH= 64, TILEHEIGHT = 64;
    protected BufferedImage texture;
    protected final int id;
    
    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this;
    }
    public void tick(){
    
    }
    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x,y,64,64, null);
    }
    public boolean isSolid(){
        return false;
    }
    
    public BufferedImage getTexture() {
        return texture;
    }

    public int getId() {
        return id;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }
}