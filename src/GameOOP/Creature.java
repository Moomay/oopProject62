/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;


public abstract class Creature extends Entity {

    
    protected float speed;
    protected float xMove, yMove;
    public static final float DEFAULT_SPEED = 3.0f;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        if (!checkEntityCollisions(xMove, 0f)) {
            moveX();
        }
        if (!checkEntityCollisions(0f, yMove)) {
            moveY();
        }
    }

    public void moveX() {
        // ทำให้ตัวละครไม่ชน tile
        if (xMove > 0) {
            
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
            if ((!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT))
                    && (!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))) {
                x += xMove;
               
            } else {
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
            }
        } else if (xMove < 0) {
            int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
            if ((!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT))
                    && (!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))) {
                x += xMove;
            } else {
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            }
        }
    }

    public void moveY() {
        if (yMove < 0) {
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
            if ((!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty))
                    && (!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))) {
                y += yMove;
            } else {
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            }

        } else if (yMove > 0) {
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            if ((!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty))
                    && (!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))) {
                y += yMove;
            } else {
                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
            }

        }

    }

    protected boolean collisionWithTile(int x, int y) {
        return (handler.getWorld(0).getTile(x, y).isSolid()||handler.getWorld(1).getTile(x, y).isSolid()||handler.getWorld(2).getTile(x, y).isSolid()||handler.getWorld(4).getTile(x, y).isSolid());
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
