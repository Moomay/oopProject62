/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject62;

import java.awt.Graphics;

/**
 *
 * @author Jame
 */
public abstract class State {
    private static State currentState = null;
    protected Handler handler;
    public State(Handler handler){
        this.handler = handler;
    }
    public static void setState(State state){
        currentState = state;
    }

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State currentState) {
        State.currentState = currentState;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
}
