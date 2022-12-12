package Main;

import Background.Board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable, KeyListener {
    public static final int blockSize = 60;
//    public static final int scale = 1;
    public static final int WIDTH = blockSize * 8;
    public static final int HEIGHT = blockSize * 8;

    private Thread thread;
    private boolean running;

    private BufferedImage image;
    private Graphics2D g;

    private final int FPS = 30;
    private int targetTime = 1000 / FPS;

    private static Board board;

    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify() {
        super.addNotify();
        if(thread == null) {
            thread = new Thread(this);
            thread.start();
        }
        addKeyListener(this);
    }

    public void run() {
        init();

        long startTime;
        long urdTime;
        long waitTime;

        while(running) {
            startTime = System.nanoTime();
            update();
            render();
            draw();

            urdTime = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - urdTime;
            if(waitTime < 0) waitTime = targetTime;

            try {
                Thread.sleep(waitTime);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void init() {
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();

        g.setColor(new Color(120, 71, 26));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        board = new Board(g);

        board.drawBoard();
        board.placePieces();
    }

    private void update() {

    }
    private void render() {

        board.draw();
    }
    private void draw() {

        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}