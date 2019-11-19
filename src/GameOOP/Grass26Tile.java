/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.image.BufferedImage;

/**
 *
 * @author Kmitl
 */
public class Grass26Tile extends Tile{
     public Grass26Tile(BufferedImage texture, int id) {
        super(Assets.tiles[26], id);
    }

    public Grass26Tile(int id) {
        super(Assets.tiles[26], id);
    }
}
