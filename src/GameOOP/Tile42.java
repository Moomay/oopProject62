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
public class Tile42  extends Tile{
    public Tile42(BufferedImage texture, int id) {
        super(Assets.tiles[42], id);
    }

    public Tile42(int id) {
        super(Assets.tiles[42], id);
    }
}
