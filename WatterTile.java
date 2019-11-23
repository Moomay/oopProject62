/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject62;

import java.awt.image.BufferedImage;

/**
 *
 * @author Jame
 */
public class WatterTile extends Tile{
    
    public WatterTile(BufferedImage texture, int id) {
        super(Assets.water, id);
    }
    public WatterTile(int id) {
        super(Assets.water, id);
    }
    public boolean isSolid() {
        return true;
    }
    
}
