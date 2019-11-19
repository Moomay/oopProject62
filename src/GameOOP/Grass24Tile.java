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
public class Grass24Tile extends Tile {

    public Grass24Tile(BufferedImage texture, int id) {
        super(texture, id);
    }

    public Grass24Tile(int id) {
        super(Assets.tiles[24], id);
    }

    

}