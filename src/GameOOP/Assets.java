/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.image.BufferedImage;
import oopproject62.ImageLoader;
import oopproject62.SpriteSheet;

/**
 *
 * @author Jame
 */
public class Assets {

    public static final int tileW = 16, tileH = 16;
    public static final int width = 24, height = 24;
    public static BufferedImage player, dirt, grass, water, tree, rock, box;
    public static BufferedImage[] player_right;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_top;
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_right0;
    public static BufferedImage[] btn_start;
    public static BufferedImage[] player_idle;

    public static BufferedImage[] playerNew_idle;
    public static BufferedImage[] playerNew_top;
    public static BufferedImage[] playerNew_down;
    public static BufferedImage[] playerNew_left;
    public static BufferedImage[] playerNew_right;

    public static BufferedImage[] tiles;
    public static BufferedImage inventory;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("mani-idle-run.png"));
        SpriteSheet playerSp = new SpriteSheet(ImageLoader.loadImage("player.png"));
        SpriteSheet worldsheet = new SpriteSheet(ImageLoader.loadImage("tile.png"));
        player_right = new BufferedImage[6];
        player_right0 = new BufferedImage[15];
        player_left = new BufferedImage[15];
        player_top = new BufferedImage[15];
        player_down = new BufferedImage[15];
        btn_start = new BufferedImage[2];
        player_idle = new BufferedImage[4];
        //new player Sheet 936 x 864 scale 12: 8
        playerNew_idle = new BufferedImage[4];
        playerNew_top = new BufferedImage[3];
        playerNew_down = new BufferedImage[3];
        playerNew_right = new BufferedImage[3];
        playerNew_left = new BufferedImage[3];
        //world tile 22:21 16*16
        tiles = new BufferedImage[463];

        player_right[0] = sheet.crop(width, 0, width, height);
        player_right[1] = sheet.crop(width * 2, 0, width, height);
        player_right[2] = sheet.crop(width * 3, 0, width, height);
        player_right[3] = sheet.crop(width * 4, 0, width, height);
        player_right[4] = sheet.crop(width * 5, 0, width, height);
        player_right[5] = sheet.crop(width * 6, 0, width, height);

        //player
        String j = "";
        for (int i = 0; i < 15; i++) {
            if (i < 10) {
                j = "0" + i;
            } else {
                j += i;
            }
            player_right0[i] = ImageLoader.loadImage("player/right/0_Warrior_Run_0" + j + ".png");
            j = "";
        }
        for (int i = 0; i < 15; i++) {
            if (i < 10) {
                j = "0" + i;
            } else {
                j += i;
            }
            player_left[i] = ImageLoader.loadImage("player/left/0_Warrior_Run_0" + j + ".png");
            j = "";
        }
        for (int i = 0; i < 15; i++) {
            if (i < 10) {
                j = "0" + i;
            } else {
                j += i;
            }
            player_down[i] = ImageLoader.loadImage("player/back/0_Warrior_Run_0" + j + ".png");
            j = "";
        }
        for (int i = 0; i < 15; i++) {
            if (i < 10) {
                j = "0" + i;
            } else {
                j += i;
            }
            player_top[i] = ImageLoader.loadImage("player/font/0_Warrior_Run_0" + j + ".png");
            j = "";
        }
        player_idle[0] = player_right0[0];
        player_idle[1] = player_left[0];
        player_idle[2] = player_down[0];
        player_idle[3] = player_top[0];
        //playerNew

        playerNew_down[0] = playerSp.crop(78 * 6, 108 * 4, 78, 108);
        playerNew_down[1] = playerSp.crop(78 * 7, 108 * 4, 78, 108);
        playerNew_down[2] = playerSp.crop(78 * 8, 108 * 4, 78, 108);

        playerNew_left[0] = playerSp.crop(78 * 6, 108 * 5, 78, 108);
        playerNew_left[1] = playerSp.crop(78 * 7, 108 * 5, 78, 108);
        playerNew_left[2] = playerSp.crop(78 * 8, 108 * 5, 78, 108);

        playerNew_right[0] = playerSp.crop(78 * 6, 108 * 6, 78, 108);
        playerNew_right[1] = playerSp.crop(78 * 7, 108 * 6, 78, 108);
        playerNew_right[2] = playerSp.crop(78 * 8, 108 * 6, 78, 108);

        playerNew_top[0] = playerSp.crop(78 * 6, 108 * 7, 78, 108);
        playerNew_top[1] = playerSp.crop(78 * 7, 108 * 7, 78, 108);
        playerNew_top[2] = playerSp.crop(78 * 8, 108 * 7, 78, 108);

        playerNew_idle[0] = playerNew_right[1];
        playerNew_idle[1] = playerNew_left[1];
        playerNew_idle[2] = playerNew_down[1];
        playerNew_idle[3] = playerNew_top[1];

        btn_start[0] = ImageLoader.loadImage("imgB.png");
        btn_start[1] = ImageLoader.loadImage("imgB1.png");
        player = sheet.crop(0, 0, 24, 24);
        tree = ImageLoader.loadImage("tree.png");
        dirt = ImageLoader.loadImage("dirt.png");
        grass = ImageLoader.loadImage("grass.png");
        water = ImageLoader.loadImage("water.png");
        rock = ImageLoader.loadImage("rock.png");
        box = ImageLoader.loadImage("box.png");
        inventory = ImageLoader.loadImage("ui.png");
        for (int y = 0; y < 21; y++) {
            for (int x = 0; x < 22; x++) {
                tiles[22*y + x+1] = worldsheet.crop(tileW * x, tileH * y, tileW, tileH);
            }
        }

    }
}
