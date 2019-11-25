/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;
import java.util.Random;


import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameController implements Runnable {

    //set up screen
    private int width = 1280;
    private int height = 720;

    private GameView view;
    private Thread thread0;
    private boolean running = false;
    //stage
    private World world;
    private World world1;
    private World world2;
    private World world3;
    private World world4;
    private BufferStrategy bs;
    private Graphics g;
    //input
    private KeyManager k1;
    private MouseManager m1;
    //camera
    private GameCamera gameCamera;
    //handler
    private Handler handler;
    //player
    private Player player;
    //e man
    private EntityManager entityManager;
    private ItemManager itemManager;

    private UIManager uiManager;
    private boolean UIvisible = false;
    private String sum = "";
    private int score = 0;
    private String word = "";
    private String[] choice;
    private String wordcheck = "";
    private String[] hint;
    private String h1, h2, h3;
    private int statworng = 0;
    private Word[] listword;
    private int timecount = 120*60;
    public GameController() {

    }

    void init() {
        Random rand = new Random();
        view = new GameView(width, height);
        k1 = new KeyManager();

        view.init();
        Assets.init();

        handler = new Handler(this);
        world = new World(handler, "world1.txt");
        world1 = new World(handler, "world2.txt");
        world2 = new World(handler, "world3.txt");
        world3 = new World(handler, "world4.txt");
        world4 = new World(handler, "world5.txt");
        choice = new String[26];
        listword = new Word[50];
        //word add
        listword[0] = new Word("GIRAFFE", "เป็นสัตว์กินพืชตัวสีเหลืองส้ม", "", "", 1);
        listword[1] = new Word("HEART", "ไม่ได้รับการดูแลมาเป็นเวลานาน", "", "", 2);
        listword[2] = new Word("NETWORK", "แขนงที่เป็นจุดแข็งของคณะ ITKMITL", "", "", 2);
        listword[3] = new Word("LOVE", "มีให้เธอแค่ข้างเดียว", "", "", 2);
        listword[4] = new Word("CONNECT", "ก่อนใช้งานinternetต้อง...", "", "", 2);
        listword[5] = new Word("DESTROY", "สิ่งที่เธอกำลังทำกับฉัน", "", "", 2);
        listword[6] = new Word("RELATIONSHIP", "สิ่งที่เธอเคยมีให้ฉัน แต่ตอนนี้ไม่มีอีกแล้ว", "", "", 2);
        listword[7] = new Word("DOG", "จีบตั้งนาน ... คาบไปกิน", "", "", 2);
        listword[8] = new Word("DESTROY", "...คนเก่ายังไม่ได้ ก็อย่าพึ่งมาคุยกับเรา", "", "", 2);
        listword[9] = new Word("COUPLE", "ฉันต้อง...กับเธอ มีเพียงแต่เธอเท่านั้น", "", "", 2);
        
        hint = new String[3];
        hint[0] = "";
        hint[1] = "";
        hint[2] = "";
        
        choice[0] = "A";
        choice[1] = "B";
        choice[2] = "C";
        choice[3] = "D";
        choice[4] = "E";
        choice[5] = "F";
        choice[6] = "G";
        choice[7] = "H";
        choice[8] = "I";
        choice[9] = "J";
        choice[10] = "K";
        choice[11] = "L";
        choice[12] = "M";
        choice[13] = "N";
        choice[14] = "O";
        choice[15] = "P";
        choice[16] = "Q";
        choice[17] = "R";
        choice[18] = "S";
        choice[19] = "T";
        choice[20] = "U";
        choice[21] = "V";
        choice[22] = "W";
        choice[23] = "X";
        choice[24] = "Y";
        choice[25] = "Z";
        h1 = hint[0];
        h2 = hint[1];
        h3 = hint[2];

        gameCamera = new GameCamera(handler, 0, 0);

        entityManager = new EntityManager(handler, new Player(handler, 350, 400));
        itemManager = new ItemManager(handler);
        entityManager.addEntity(new House(handler, 200, 800));
        entityManager.addEntity(new Tree(handler, 100, 150));
        entityManager.addEntity(new Tree(handler, 1000, 500));
        entityManager.addEntity(new Tree(handler, 1000, 1000));
        //itemManager.addItem(Item.boxItem.createNew(300, 300));
        itemManager.addItem(new Item(Assets.box, "box", listword[rand.nextInt(9)]).createNew(rand.nextInt(100)+300, 300));
        itemManager.addItem(new Item(Assets.box, "box", listword[rand.nextInt(9)]).createNew(rand.nextInt(100)+500, rand.nextInt(400)+1000));
        itemManager.addItem(new Item(Assets.box, "box", listword[rand.nextInt(9)]).createNew(rand.nextInt(2000)+300, rand.nextInt(400)+1500));
        itemManager.addItem(new Item(Assets.box, "box", listword[rand.nextInt(9)]).createNew(rand.nextInt(500)+200, rand.nextInt(900)+100));
        itemManager.addItem(new Item(Assets.box, "box", listword[rand.nextInt(9)]).createNew(rand.nextInt(2000), rand.nextInt(2000)+500));
        itemManager.addItem(new Item(Assets.box, "box", listword[rand.nextInt(9)]).createNew(rand.nextInt(2000), rand.nextInt(2000)+500));
        itemManager.addItem(new Item(Assets.box, "box", listword[rand.nextInt(9)]).createNew(rand.nextInt(2000), rand.nextInt(2000)+500));
        uiManager = new UIManager(handler);

        uiManager.addObject(new UIbotton("X", 1200, 140, 64, 64, new ClickListener() {
            public void onClick() {
                sum = "";
                if (word.equals("")){
                    wordcheck="";
                }
                UIvisible = false;
            }
        }));
        uiManager.addObject(new UIbotton("          Clear", 1010, 190, 200, 64, new ClickListener() {
            public void onClick() {
                sum = "";
            }
        }));
        uiManager.addObject(new UIbotton("          Enter", 1010, 500, 200, 64, new ClickListener() {
            public void onClick() {
                if (word.equals(sum) && !(word.equals(""))) {
                    score += word.length();
                    System.out.println("win");
                    sum = "";
                    word = "";
                    h1 = "";
                    h2 = "";
                    h3 = "";
                    UIvisible = false;
                } else if(statworng == 3){
                    sum = word + "                Anwser";
                    wordcheck = "";
                    word = "";
                    statworng = 0;
                }else {
                    statworng += 1;
                }
                if (statworng >= 1){
                    wordcheck = "Worng" + statworng;  
                } 
                
                System.out.println(word);
            }
        }));
        /*uiManager.addObject(new UIbotton("Set", 1010, 600, 64, 64, new ClickListener() {

            public void onClick() {
                word = sum;
            }
        }));
*/
        uiManager.addObject(new UIbotton(choice[0], 40, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[0];
            }
        }));

        uiManager.addObject(new UIbotton(choice[1], 120, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[1];
            }
        }));
        uiManager.addObject(new UIbotton(choice[2], 200, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[2];
            }
        }));
        uiManager.addObject(new UIbotton(choice[3], 280, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[3];
            }
        }));
        uiManager.addObject(new UIbotton(choice[4], 360, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[4];
            }
        }));
        uiManager.addObject(new UIbotton(choice[5], 440, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[5];
            }
        }));
        uiManager.addObject(new UIbotton(choice[6], 520, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[6];
            }
        }));
        //row 2;

        uiManager.addObject(new UIbotton(choice[7], 600, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[7];
            }
        }));

        uiManager.addObject(new UIbotton(choice[8], 680, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[8];
            }
        }));
        uiManager.addObject(new UIbotton(choice[9], 760, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[9];
            }
        }));
        uiManager.addObject(new UIbotton(choice[10], 840, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[10];
            }
        }));
        uiManager.addObject(new UIbotton(choice[11], 920, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[11];
            }
        }));
        uiManager.addObject(new UIbotton(choice[12], 1000, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[12];
            }
        }));
        uiManager.addObject(new UIbotton(choice[13], 40, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[13];
            }
        }));
        uiManager.addObject(new UIbotton(choice[14], 120, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[14];
            }
        }));
        uiManager.addObject(new UIbotton(choice[15], 200, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[15];
            }
        }));
        uiManager.addObject(new UIbotton(choice[16], 280, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[16];
            }
        }));
        uiManager.addObject(new UIbotton(choice[17], 360, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[17];
            }
        }));
        uiManager.addObject(new UIbotton(choice[18], 440, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[18];
            }
        }));
        uiManager.addObject(new UIbotton(choice[19], 520, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[19];
            }
        }));
        uiManager.addObject(new UIbotton(choice[20], 600, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[20];
            }
        }));
        uiManager.addObject(new UIbotton(choice[21], 680, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[21];
            }
        }));
        uiManager.addObject(new UIbotton(choice[22], 760, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[22];
            }
        }));
        uiManager.addObject(new UIbotton(choice[23], 840, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[23];
            }
        }));
        uiManager.addObject(new UIbotton(choice[24], 920, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[24];
            }
        }));
        uiManager.addObject(new UIbotton(choice[25], 1000, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[25];
            }
        }));
        
        handler.addWorld(world);
        handler.addWorld(world1);
        handler.addWorld(world2);
        handler.addWorld(world3);
        handler.addWorld(world4);

        m1 = new MouseManager(handler);
        m1.setUIManager(uiManager);
        view.getF1().addKeyListener(k1);
        view.getF1().addMouseListener(m1);
        view.getF1().addMouseMotionListener(m1);

        view.getC1().addMouseMotionListener(m1);
        view.getC1().addMouseListener(m1);

    }

    private void tick() {
        //gm comand
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
            UIvisible = !UIvisible;
        }
        timecount -= 1;
        
        k1.tick();
        itemManager.tick();
        uiManager.tick();
        entityManager.tick();
        

    }

    private void render() {
        bs = view.getC1().getBufferStrategy();
        if (bs == null) {
            view.getC1().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Claer Screen
        g.clearRect(0, 0, width, height);

        //Draw
        world.render(g);
        world1.render(g);
        world2.render(g);
        world3.render(g);
        //world4.render(g);
        itemManager.render(g);
        entityManager.render(g);
        if (UIvisible) {
            g.drawImage(Assets.inventory, 20, 140, 1240, 580, null);
          
            Text.drawString(g, "Character :"+ word.length(), 50, 220, false, Color.black, Assets.font28);
            Text.drawString(g, sum, 500, 220, true, Color.black, Assets.font28);
            if(statworng >= 0){
                 Text.drawString(g, h1, 500, 580, true, Color.black, Assets.font28);
                 Text.drawString(g, h2, 500, 620, true, Color.black, Assets.font28);
                 Text.drawString(g, h3, 500, 660, true, Color.black, Assets.font28);
                 Text.drawString(g, wordcheck, 880, 220, false, Color.red, Assets.font28);
            uiManager.render(g);
            }
        }
        Text.drawString(g, "score : " + score, 1200, 40, true, Color.yellow, Assets.font28);
        Text.drawString(g, timecount/60+"", 40, 40, true, Color.yellow, Assets.font28);
        if (timecount <= 0){
            g.fillRect(0, 0, width, height);
            Text.drawString(g, "score : " + score, 550, 360, false, Color.red, Assets.font28);
            
        }
       
        //Text.drawString(g, "น้องปืน", 640, 300, true, Color.pink, Assets.font28);
        //g.setColor(Color.red);
        //g.fillRect(10, 10, 50, 200);
        //System.out.println(entityManager.getPlayer().x - handler.getGameCamera().getxOffset() + "   " + (entityManager.getPlayer().y - handler.getGameCamera().getyOffset()));
        /*g.setColor(Color.red);
        g.drawRect(20, 10, 50, 200);
        ImageIcon i = new ImageIcon("test.jpg");
        img = i.getImage();
        g.drawImage(img, 200, 300, null);*/
        //168 x 24 : 7
        //end Drawing
        bs.show();
        g.dispose();
    }

    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {

                ticks = 0;
                timer = 0;
            }

        }
        stop();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public GameView getView() {
        return view;
    }

    public synchronized void start() {
        running = true;
        thread0 = new Thread(this);
        thread0.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread0.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        GameController game = new GameController();
        game.start();
        
        

    }

    public KeyManager getK1() {
        return k1;
    }

    public void setK1(KeyManager k1) {
        this.k1 = k1;
    }

    public MouseManager getM1() {
        return m1;
    }

    public void setM1(MouseManager m1) {
        this.m1 = m1;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public void setGameCamera(GameCamera gameCamera) {
        this.gameCamera = gameCamera;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String[] getChoice() {
        return choice;
    }

    public void setChoice(String[] choice) {
        this.choice = choice;
    }

    public String[] getHint() {
        return hint;
    }

    public void setHint(String[] hint) {
        this.hint = hint;
    }

    public void setHint(String h1, String h2, String h3) {
        this.h1 = h1;
        this.h2 = h2;
        this.h3 = h3;
    }

    public void setUIvisible(boolean UIvisible) {
        this.UIvisible = UIvisible;
    }

    public int getStatworng() {
        return statworng;
    }

    public void setStatworng(int statworng) {
        this.statworng = statworng;
    }

    public void setWordcheck(String wordcheck) {
        this.wordcheck = wordcheck;
    }

    
    
}
