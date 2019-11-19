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
public class Tile64  extends Tile{
    public Tile64(BufferedImage texture, int id) {
        super(Assets.tiles[64], id);
    }

    public Tile64(int id) {
        super(Assets.tiles[64], id);
    }
}
