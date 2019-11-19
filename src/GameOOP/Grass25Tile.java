/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.image.BufferedImage;

/**
 *
 * @author Jame
 */
public class Grass25Tile extends Tile{
    
    public Grass25Tile(BufferedImage texture, int id) {
        super(Assets.tiles[25], id);
    }

    public Grass25Tile(int id) {
        super(Assets.tiles[25], id);
    }
    
}
