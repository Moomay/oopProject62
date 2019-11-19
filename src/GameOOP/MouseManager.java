/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

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
    private Handler handler;

    public MouseManager(Handler handler) {
         this.handler = handler;
    }


    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
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
            System.out.println("L Click   " + mouseX + "//" + mouseY );
            leftPressed = true;
        } else if (me.getButton() == MouseEvent.BUTTON3) {
            System.out.println("R Click");
            rightPressed = true;
        }
    }

    public void mouseReleased(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON1) {
            if (mouseX >= 10 && mouseX <= 60 &&mouseY >= 10 && mouseY <= 210){
                System.out.println("Here ON");
            }
            System.out.println("RE L");
            
            leftPressed = false;
        } else if (me.getButton() == MouseEvent.BUTTON3) {
            System.out.println("RE R");
            rightPressed = false;
        }
        
        
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
        //System.out.println(mouseX+ "//" +mouseY);
        
    }
    

}