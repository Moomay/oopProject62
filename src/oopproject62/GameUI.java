
import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prize
 */
public class GameUI extends JPanel {

    private JFrame f1;
    private JMenuBar mb1;
    private JMenu m1, m2;
    private JMenuItem mi1,mi2,mi3,mi4,mi5;
    
    public void init(){
        // step 1
        f1 = new JFrame("Word Of The Death");
        
        mb1 = new JMenuBar();
        
        m1 = new JMenu("File");
        m2 = new JMenu("New");
        
        mi1 = new JMenuItem("Open");
        mi2 = new JMenuItem("Save");
        mi3 = new JMenuItem("Exit");
        mi4 = new JMenuItem("Window");
        mi5 = new JMenuItem("Message");
        
        // step 2
        f1.setSize(800, 600);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setBackground(Color.black);
        
        // step 3
        f1.setJMenuBar(mb1);
        
        mb1.add(m1);
        
        m1.add(m2);
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        
        m2.add(mi4);
        m2.add(mi5);
        
        f1.getContentPane().setBackground(Color.black);
    }
    
}
