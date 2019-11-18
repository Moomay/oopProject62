/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject62;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Jame
 */
public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener() {

            public void onClick() {
                State.setState(handler.getGame().gameState);
            }

        }));
    }

    public void tick() {
        uiManager.tick();
        
        
        
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }

}
