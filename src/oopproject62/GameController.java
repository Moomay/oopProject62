/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject62;

/**
 *
 * @author Jame
 */
public class GameController implements Runnable{
    
    public static void main(String[] args) {
        GameView view = new GameView(1920, 800);
        view.init();
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
