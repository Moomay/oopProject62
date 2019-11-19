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
public class Tile33  extends Tile{
    public Tile33(BufferedImage texture, int id) {
        super(Assets.tiles[33], id);
    }

    public Tile33(int id) {
        super(Assets.tiles[33], id);
    }
}
