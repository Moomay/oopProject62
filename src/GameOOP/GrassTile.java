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
public class GrassTile extends Tile {

    public GrassTile(int id) {
        super(Assets.grass, id);
    }

    public GrassTile(BufferedImage texture, int id) {
         super(Assets.grass, id);
    }

}
