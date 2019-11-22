/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOOP;

/**
 *
 * @author Jame
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import oopproject62.UIObject;

/**
 *
 * @author Jame
 */
public class GameController implements Runnable {

    //set up screen
    private int width = 1280;
    private int height = 720;

    private BufferedImage testImage;
    private GameView view;
    private ImageIcon i;
    private Image img;
    private SpriteSheet sheet;
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

    private ArrayList<UIObject> objects;
    private UIbotton reset;

    private UIManager uiManager;
    private boolean UIvisible = true;
    private String sum = "";
    private int score = 0;
    private String word = "EA";
    private String[] choice;
    private String[] hint;
    
    public GameController() {

    }

    void init() {
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
        choice = new String[14];
        hint = new String[3];
        hint[0] = "อะไรว่ะ";
        hint[1] = "งงcode";
        hint[2] = "ลาก่อน";
        choice[0] = "A";
        choice[1] = "B";
        choice[2] = "C";
        choice[3] = "D";
        choice[4] = "E";
        choice[5] = "F";
        choice[6] = "I";
        choice[7] = "J";
        choice[8] = "K";
        choice[9] = "L";
        choice[10] = "M";
        choice[11] = "N";
        choice[12] = "G";
        choice[13] = "P";
        
        //reset = new UIbotton()
        gameCamera = new GameCamera(handler, 0, 0);

        entityManager = new EntityManager(handler, new Player(handler, 500, 400));
        itemManager = new ItemManager(handler);
        /*entityManager.addEntity(new Tree(handler, 256, 256));
        entityManager.addEntity(new Tree(handler, 150, 500));
        entityManager.addEntity(new Rock(handler, 100, 450));
        entityManager.addEntity(new Rock(handler, 300, 230));
        entityManager.addEntity(new Rock(handler, 450, 450));*/
        itemManager.addItem(Item.boxItem.createNew(300, 300));

        uiManager = new UIManager(handler);

        uiManager.addObject(new UIbotton("X", 1200, 140, 64, 64, new ClickListener() {
            public void onClick() {
                sum = "";
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
                if (word.equals(sum)) {
                    System.out.println("win");
                }
            }
        }));
        uiManager.addObject(new UIbotton("Set", 1010, 600, 64, 64, new ClickListener() {

            public void onClick() {
                word = sum;
            }
        }));

        uiManager.addObject(new UIbotton(choice[0], 40, 280, 64, 64,  new ClickListener() {

            public void onClick() {
                sum += choice[0];
            }
        }));

        uiManager.addObject(new UIbotton(choice[1], 200, 280, 64, 64,  new ClickListener() {

            public void onClick() {
                sum += choice[1];
            }
        }));
        uiManager.addObject(new UIbotton(choice[2], 360, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[2];
            }
        }));
        uiManager.addObject(new UIbotton(choice[3], 520, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[3];
            }
        }));
        uiManager.addObject(new UIbotton(choice[4], 680, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[4];
            }
        }));
        uiManager.addObject(new UIbotton(choice[5], 840, 280, 64, 64,  new ClickListener() {

            public void onClick() {
                sum += choice[5];
            }
        }));
        uiManager.addObject(new UIbotton(choice[6], 1000, 280, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[6];
            }
        }));
        //row 2;
        
        uiManager.addObject(new UIbotton(choice[7], 40, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[7];
            }
        }));

        uiManager.addObject(new UIbotton(choice[8], 200, 360, 64, 64,  new ClickListener() {

            public void onClick() {
                sum += choice[8];
            }
        }));
        uiManager.addObject(new UIbotton(choice[9], 360, 360, 64, 64,  new ClickListener() {

            public void onClick() {
                sum += choice[9];
            }
        }));
        uiManager.addObject(new UIbotton(choice[10], 520, 360, 64, 64,  new ClickListener() {

            public void onClick() {
                sum += choice[10];
            }
        }));
        uiManager.addObject(new UIbotton(choice[11], 680, 360, 64, 64,  new ClickListener() {

            public void onClick() {
                sum += choice[11];
            }
        }));
        uiManager.addObject(new UIbotton(choice[12], 840, 360, 64, 64,  new ClickListener() {

            public void onClick() {
                sum += choice[12];
            }
        }));
        uiManager.addObject(new UIbotton(choice[13], 1000, 360, 64, 64, new ClickListener() {

            public void onClick() {
                sum += choice[13];
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
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
            UIvisible =!UIvisible;
        
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
            //g.drawImage(Assets.inventory, 20, 140, 1240, 500, null);
            Text.drawString(g, sum, 500, 200, true, Color.black, Assets.font28);
            Text.drawString(g, hint[0], 500, 480, true, Color.black, Assets.font28);
            Text.drawString(g, hint[1], 500, 520, true, Color.black, Assets.font28);
            Text.drawString(g, hint[2], 500, 560, true, Color.black, Assets.font28);
            uiManager.render(g);
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
    public void setHint(String h1,String h2,String h3){
        hint[0] = h1;
        hint[1] = h2;
        hint[2] = h3;
    }
    
}
