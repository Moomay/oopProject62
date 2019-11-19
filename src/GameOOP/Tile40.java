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
public class Tile40  extends Tile{
    public Tile40(BufferedImage texture, int id) {
        super(Assets.tiles[40], id);
    }

    public Tile40(int id) {
        super(Assets.tiles[40], id);
    }
}
