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
public class Tile30  extends Tile{
    public Tile30(BufferedImage texture, int id) {
        super(Assets.tiles[30], id);
    }

    public Tile30(int id) {
        super(Assets.tiles[30], id);
    }
}
