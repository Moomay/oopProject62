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

    public static final int width = 24,height = 24;
    public static BufferedImage player, dirt, grass, water,tree;
    public static BufferedImage[] player_right;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("mani-idle-run.png"));
        player_right = new BufferedImage[6];

        player_right[0] = sheet.crop(width, 0, width,height);
        player_right[1] = sheet.crop(width*2, 0, width,height);
        player_right[2] = sheet.crop(width*3, 0, width,height);
        player_right[3] = sheet.crop(width*4, 0, width,height);
        player_right[4] = sheet.crop(width*5, 0, width,height);
        player_right[5] = sheet.crop(width*6, 0, width,height);
        player = sheet.crop(0, 0, 24, 24);
        tree = ImageLoader.loadImage("tree.png");
        dirt = ImageLoader.loadImage("dirt.png");
        grass = ImageLoader.loadImage("grass.png");
        water = ImageLoader.loadImage("water.png");
    }
}
