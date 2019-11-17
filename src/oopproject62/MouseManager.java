/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject62;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Jame
 */
public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;

    public MouseManager() {
        
    }
    public boolean isLeftPressed(){
        return leftPressed;
    }
    public boolean isRightPressed(){
        return rightPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }
    

    public void mouseClicked(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON1) {
            leftPressed = true;
        }
        else if (me.getButton() == MouseEvent.BUTTON3){
            rightPressed = true;
        }
    }

    public void mouseReleased(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON1)
            leftPressed = false;
        else if (me.getButton() == MouseEvent.BUTTON3)
            rightPressed = false;
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mouseDragged(MouseEvent me) {
    }

    public void mouseMoved(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
    }

}
