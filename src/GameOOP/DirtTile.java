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
public class DirtTile extends Tile {

    public DirtTile(BufferedImage texture, int id) {
        super(Assets.dirt, id);
    }

    public DirtTile(int id) {
        super(Assets.dirt, id);
    }

    

}
