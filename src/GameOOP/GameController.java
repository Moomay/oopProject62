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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Jame
 */
public class GameController implements Runnable {

    //set up screen
    private int width = 640;
    private int height = 640;

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
        gameCamera = new GameCamera(handler, 0, 0);

        entityManager = new EntityManager(handler, new Player(handler, 0, 0));
        itemManager = new ItemManager(handler);
        entityManager.addEntity(new Tree(handler, 256, 256));
        entityManager.addEntity(new Tree(handler, 150, 500));
        entityManager.addEntity(new Rock(handler, 100, 450));
        entityManager.addEntity(new Rock(handler, 300, 230));
        entityManager.addEntity(new Rock(handler, 450, 450));
        itemManager.addItem(Item.boxItem.createNew(300, 300));

        handler.addWorld(world);
        handler.addWorld(world1);
        m1 = new MouseManager(handler);
        view.getF1().addKeyListener(k1);
        view.getF1().addMouseListener(m1);
        view.getF1().addMouseMotionListener(m1);

        view.getC1().addMouseMotionListener(m1);
        view.getC1().addMouseListener(m1);

    }

    private void tick() {

        k1.tick();
        itemManager.tick();

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
        itemManager.render(g);

        entityManager.render(g);

        g.setColor(Color.red);
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

}
