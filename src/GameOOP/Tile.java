/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jame
 */
public class Tile {

    //static stuff here
    public static Tile[] tiles = new Tile[500];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile watterTile = new WatterTile(2);
    //public static Tile tile27 = new Tile(Assets.tiles[0], 0);

    public static Tile tile0 = new Tile(Assets.tiles[0], 0);
    public static Tile tile24 = new Tile(Assets.tiles[24], 24);
    public static Tile tile26 = new Tile(Assets.tiles[26], 26);
    public static Tile tile27 = new Tile(Assets.tiles[27], 27);
    public static Tile tile29 = new Tile(Assets.tiles[29], 29);
    public static Tile tile30 = new Tile(Assets.tiles[30], 30);
    public static Tile tile31 = new Tile(Assets.tiles[31], 31);
    public static Tile tile36 = new Tile(Assets.tiles[36], 36);
    public static Tile tile37 = new Tile(Assets.tiles[37], 37);
    public static Tile tile39 = new Tile(Assets.tiles[39], 39);
    public static Tile tile40 = new Tile(Assets.tiles[40], 40);
    public static Tile tile41 = new Tile(Assets.tiles[41], 41);
    public static Tile tile42 = new Tile(Assets.tiles[42], 42);
    public static Tile tile43 = new Tile(Assets.tiles[43], 43);
    public static Tile tile46 = new Tile(Assets.tiles[46], 46);
    public static Tile tile51 = new Tile(Assets.tiles[51], 51);
    public static Tile tile53 = new Tile(Assets.tiles[53], 53);
    public static Tile tile58 = new Tile(Assets.tiles[58], 58);
    public static Tile tile59 = new Tile(Assets.tiles[59], 59);
    public static Tile tile61 = new Tile(Assets.tiles[61], 61);
    public static Tile tile62 = new Tile(Assets.tiles[62], 62);
    public static Tile tile63 = new Tile(Assets.tiles[63], 63);
    public static Tile tile64 = new Tile(Assets.tiles[64], 64);
    public static Tile tile65 = new Tile(Assets.tiles[65], 65);
    public static Tile tile68 = new Tile(Assets.tiles[68], 68);
    public static Tile tile69 = new Tile(Assets.tiles[69], 69);
    public static Tile tile70 = new Tile(Assets.tiles[70], 70);
    public static Tile tile72 = new Tile(Assets.tiles[72], 72);
    public static Tile tile73 = new Tile(Assets.tiles[73], 73);
    public static Tile tile75 = new Tile(Assets.tiles[75], 75);
    public static Tile tile83 = new Tile(Assets.tiles[83], 83);
    public static Tile tile84 = new Tile(Assets.tiles[84], 84);
    public static Tile tile85 = new Tile(Assets.tiles[85], 85);
    public static Tile tile94 = new Tile(Assets.tiles[94], 94);
    public static Tile tile95 = new Tile(Assets.tiles[95], 95);
    public static Tile tile116 = new Tile(Assets.tiles[116], 116);
    public static Tile tile117 = new Tile(Assets.tiles[117], 117);
    public static Tile tile118 = new Tile(Assets.tiles[118], 118);
    public static Tile tile119 = new Tile(Assets.tiles[119], 119);
    public static Tile tile121 = new Tile(Assets.tiles[121], 121);
    public static Tile tile122 = new Tile(Assets.tiles[122], 122);
    public static Tile tile123 = new Tile(Assets.tiles[123], 123);
    public static Tile tile124 = new Tile(Assets.tiles[124], 124);
    public static Tile tile125 = new Tile(Assets.tiles[125], 125);
    public static Tile tile126 = new Tile(Assets.tiles[126], 126);
    public static Tile tile127 = new Tile(Assets.tiles[127], 127);
    public static Tile tile128 = new Tile(Assets.tiles[128], 128);
    public static Tile tile129 = new Tile(Assets.tiles[129], 129);
    public static Tile tile130 = new Tile(Assets.tiles[130], 130);
    public static Tile tile135 = new Tile(Assets.tiles[135], 135);
    public static Tile tile136 = new Tile(Assets.tiles[136], 136);
    public static Tile tile137 = new Tile(Assets.tiles[137], 137);
    public static Tile tile138 = new Tile(Assets.tiles[138], 138);
    public static Tile tile143 = new Tile(Assets.tiles[143], 143);
    public static Tile tile144 = new Tile(Assets.tiles[144], 144);
    public static Tile tile145 = new Tile(Assets.tiles[145], 145);
    public static Tile tile146 = new Tile(Assets.tiles[146], 146);
    public static Tile tile147 = new Tile(Assets.tiles[147], 147);
    public static Tile tile148 = new Tile(Assets.tiles[148], 148);
    public static Tile tile149 = new Tile(Assets.tiles[149], 149);
    public static Tile tile150 = new Tile(Assets.tiles[150], 150);
    public static Tile tile151 = new Tile(Assets.tiles[151], 151);
    public static Tile tile152 = new Tile(Assets.tiles[152], 152);
    public static Tile tile157 = new Tile(Assets.tiles[157], 157);
    public static Tile tile158 = new Tile(Assets.tiles[158], 158);
    public static Tile tile159 = new Tile(Assets.tiles[159], 159);
    public static Tile tile160 = new Tile(Assets.tiles[160], 160);
    public static Tile tile165 = new Tile(Assets.tiles[165], 165);
    public static Tile tile166 = new Tile(Assets.tiles[166], 166);
    public static Tile tile167 = new Tile(Assets.tiles[167], 167);
    public static Tile tile168 = new Tile(Assets.tiles[168], 168);
    public static Tile tile169 = new Tile(Assets.tiles[169], 169);
    public static Tile tile170 = new Tile(Assets.tiles[170], 170);
    public static Tile tile171 = new Tile(Assets.tiles[171], 171);
    public static Tile tile172 = new Tile(Assets.tiles[172], 172);
    public static Tile tile173 = new Tile(Assets.tiles[173], 173);
    public static Tile tile174 = new Tile(Assets.tiles[174], 174);
    public static Tile tile184 = new Tile(Assets.tiles[184], 184);
    public static Tile tile185 = new Tile(Assets.tiles[185], 185);
    public static Tile tile187 = new Tile(Assets.tiles[187], 187);
    public static Tile tile188 = new Tile(Assets.tiles[188], 188);
    public static Tile tile192 = new Tile(Assets.tiles[192], 192);
    public static Tile tile193 = new Tile(Assets.tiles[193], 193);
    public static Tile tile194 = new Tile(Assets.tiles[194], 194);
    public static Tile tile195 = new Tile(Assets.tiles[195], 195);
    public static Tile tile196 = new Tile(Assets.tiles[196], 196);
    public static Tile tile214 = new Tile(Assets.tiles[214], 214);
    public static Tile tile215 = new Tile(Assets.tiles[215], 215);
    public static Tile tile216 = new Tile(Assets.tiles[216], 216);
    public static Tile tile217 = new Tile(Assets.tiles[217], 217);
    public static Tile tile236 = new Tile(Assets.tiles[236], 236);
    public static Tile tile237 = new Tile(Assets.tiles[237], 237);
    public static Tile tile238 = new Tile(Assets.tiles[238], 238);
    public static Tile tile239 = new Tile(Assets.tiles[239], 239);
    public static Tile tile247 = new Tile(Assets.tiles[247], 247);
    public static Tile tile249 = new Tile(Assets.tiles[249], 249);
    public static Tile tile250 = new Tile(Assets.tiles[250], 250);
    public static Tile tile276 = new Tile(Assets.tiles[276], 276);
    public static Tile tile277 = new Tile(Assets.tiles[277], 277);
    public static Tile tile278 = new Tile(Assets.tiles[278], 278);
    public static Tile tile321 = new Tile(Assets.tiles[321], 321);
    public static Tile tile322 = new Tile(Assets.tiles[322], 322);
    public static Tile tile326 = new Tile(Assets.tiles[326], 326);
    public static Tile tile339 = new Tile(Assets.tiles[339], 339);
    public static Tile tile342 = new Tile(Assets.tiles[342], 342);
    public static Tile tile343 = new Tile(Assets.tiles[343], 343);
    public static Tile tile344 = new Tile(Assets.tiles[344], 344);
    public static Tile tile348 = new Tile(Assets.tiles[348], 348);
    public static Tile tile361 = new Tile(Assets.tiles[361], 361);
    public static Tile tile364 = new Tile(Assets.tiles[364], 364);
    public static Tile tile365 = new Tile(Assets.tiles[365], 365);
    public static Tile tile366 = new Tile(Assets.tiles[366], 366);
    public static Tile tile367 = new Tile(Assets.tiles[367], 367);
    public static Tile tile368 = new Tile(Assets.tiles[368], 368);
    public static Tile tile369 = new Tile(Assets.tiles[369], 369);
    public static Tile tile370 = new Tile(Assets.tiles[370], 370);
    public static Tile tile383 = new Tile(Assets.tiles[383], 383);
    public static Tile tile386 = new Tile(Assets.tiles[386], 386);
    public static Tile tile387 = new Tile(Assets.tiles[387], 387);
    public static Tile tile388 = new Tile(Assets.tiles[388], 388);
    public static Tile tile389 = new Tile(Assets.tiles[389], 389);
    public static Tile tile390 = new Tile(Assets.tiles[390], 390);
    public static Tile tile391 = new Tile(Assets.tiles[391], 391);
    public static Tile tile408 = new Tile(Assets.tiles[408], 408);
    public static Tile tile410 = new Tile(Assets.tiles[410], 410);
    public static Tile tile420 = new Tile(Assets.tiles[420], 420);
    public static Tile tile421 = new Tile(Assets.tiles[421], 421);
    public static Tile tile422 = new Tile(Assets.tiles[422], 422);
    public static Tile tile423 = new Tile(Assets.tiles[423], 423);
    public static Tile tile424 = new Tile(Assets.tiles[424], 424);
    public static Tile tile431 = new Tile(Assets.tiles[431], 431);
    public static Tile tile432 = new Tile(Assets.tiles[432], 432);
    public static Tile tile442 = new Tile(Assets.tiles[442], 442);
    public static Tile tile443 = new Tile(Assets.tiles[443], 443);
    public static Tile tile33 = new Tile(Assets.tiles[33], 33, true);
    public static Tile tile34 = new Tile(Assets.tiles[34], 34, true);
    public static Tile tile35 = new Tile(Assets.tiles[35], 35, true);
    public static Tile tile55 = new Tile(Assets.tiles[55], 55, true);
    public static Tile tile56 = new Tile(Assets.tiles[56], 56, true);
    public static Tile tile57 = new Tile(Assets.tiles[57], 57, true);
    public static Tile tile79 = new Tile(Assets.tiles[79], 79, true);
    public static Tile tile180 = new Tile(Assets.tiles[180], 180, true);
    public static Tile tile202 = new Tile(Assets.tiles[202], 202, true);
    public static Tile tile206 = new Tile(Assets.tiles[206], 206, true);
    public static Tile tile207 = new Tile(Assets.tiles[207], 207, true);
    public static Tile tile208 = new Tile(Assets.tiles[208], 208, true);
    public static Tile tile222 = new Tile(Assets.tiles[222], 222, true);
    public static Tile tile223 = new Tile(Assets.tiles[223], 223, true);
    public static Tile tile224 = new Tile(Assets.tiles[224], 224, true);
    public static Tile tile227 = new Tile(Assets.tiles[227], 227, true);
    public static Tile tile228 = new Tile(Assets.tiles[228], 228, true);
    public static Tile tile229 = new Tile(Assets.tiles[229], 229, true);
    public static Tile tile244 = new Tile(Assets.tiles[244], 244, true);
    public static Tile tile245 = new Tile(Assets.tiles[245], 245, true);
    public static Tile tile246 = new Tile(Assets.tiles[246], 246, true);
    public static Tile tile266 = new Tile(Assets.tiles[266], 266, true);
    public static Tile tile267 = new Tile(Assets.tiles[267], 267, true);
    public static Tile tile268 = new Tile(Assets.tiles[268], 268, true);
    public static Tile tile269 = new Tile(Assets.tiles[269], 269, true);
    public static Tile tile270 = new Tile(Assets.tiles[270], 270, true);
    public static Tile tile271 = new Tile(Assets.tiles[271], 271, true);
    public static Tile tile272 = new Tile(Assets.tiles[272], 272, true);
    public static Tile tile294 = new Tile(Assets.tiles[294], 294, true);
    public static Tile tile295 = new Tile(Assets.tiles[295], 295, true);
    public static Tile tile316 = new Tile(Assets.tiles[316], 316, true);
    public static Tile tile317 = new Tile(Assets.tiles[317], 317, true);
    public static Tile tile2 = new Tile(Assets.tiles[2], 2, true);
    //class
    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
    protected BufferedImage texture;
    protected final int id;
    private boolean isSolid;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
        this.isSolid = false;
        tiles[id] = this;
    }

    public Tile(BufferedImage texture, int id, boolean l) {
        this.texture = texture;
        this.id = id;
        this.isSolid = l;
        tiles[id] = this;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, 64, 64, null);
    }

    public boolean isSolid() {
        return getIsSolid();
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public boolean getIsSolid() {
        return isSolid;
    }

    public void setIsSolid(boolean l) {
        this.isSolid = l;
    }

    public int getId() {
        return id;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }
}
