/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Jame
 */
public class KeyManager implements KeyListener {

    private boolean[] keys, justPressed, cantPress;
    public boolean up, down, left, right;
    public boolean aUp, aDown, aLeft, aRight;

    public KeyManager() {
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];
    }

    public void tick() {
        
        for (int i = 0; i < keys.length; i++) {
            if (cantPress[i] && !keys[i]) {
                cantPress[i] = false;
            } else if (justPressed[i]) {
                cantPress[i] = true;
                justPressed[i] = false;
            }
            if (!cantPress[i] && keys[i]) {
                justPressed[i] = true;
            }
        }
        if (keyJustPressed(KeyEvent.VK_E)) {
            System.out.println("e");
        }
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];

        
    }

    public void keyTyped(KeyEvent ke) {
        //

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() < 0 || ke.getKeyCode() >= keys.length) {
            return;
        }
        keys[ke.getKeyCode()] = true;

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() < 0 || ke.getKeyCode() >= keys.length) {
            return;
        }
        keys[ke.getKeyCode()] = false;

    }

    public boolean keyJustPressed(int keyCode) {
        if (keyCode < 0 || keyCode >= keys.length) {
            return false;
        }
        return justPressed[keyCode];
    }
}
