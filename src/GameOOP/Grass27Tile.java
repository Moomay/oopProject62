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
public class Grass27Tile extends Tile{
    public Grass27Tile(BufferedImage texture, int id) {
        super(Assets.tiles[27], id);
    }

    public Grass27Tile(int id) {
        super(Assets.tiles[27], id);
    }
}
