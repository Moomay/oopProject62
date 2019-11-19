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
public class Tile75  extends Tile{
    public Tile75(BufferedImage texture, int id) {
        super(Assets.tiles[75], id);
    }

    public Tile75(int id) {
        super(Assets.tiles[75], id);
    }
}
