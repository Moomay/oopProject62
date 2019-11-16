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
public class Assets {
    
    public static BufferedImage player, dirt, grass, water;
    
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("mani-idle-run.png"));
        player = sheet.crop(0,0,24,24);
        dirt = ImageLoader.loadImage("dirt.png");
        grass = ImageLoader.loadImage("grass.png");
        water = ImageLoader.loadImage("water.png");
    }
}
