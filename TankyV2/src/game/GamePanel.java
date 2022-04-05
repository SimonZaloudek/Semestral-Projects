package game;

import entities.Player;
import tools.Canvas;
import tools.KeyHandler;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class GamePanel extends JPanel implements Runnable {

    private Thread thread;
    private final Player player;
    private final Tower tower;

    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;

    private long lastFrame;
    private final int tankN;

    public GamePanel(Canvas canvas) {
        this.panel(Color.WHITE, WIDTH, HEIGHT);
        this.tankN = canvas.getTankN();

        KeyHandler handler = new KeyHandler();

        this.player = new Player(this, handler);
        this.tower = new Tower(this, handler);
        super.setLayout(null);

        super.addKeyListener(handler);
        super.addMouseMotionListener(this.tower);
        this.startTread();

        this.lastFrame = System.nanoTime();
    }

    public void panel(Color color, int width, int height) {
        super.setBackground(color);
        super.setPreferredSize(new Dimension(width, height));
    }

    public void startTread() {
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        while (this.thread != null) {
            if (System.nanoTime() < this.lastFrame + 16000000) {
                continue;
            }
            this.lastFrame = System.nanoTime();
            this.update();
            this.repaint();
        }
    }

    public void update() {
        this.player.update();
        this.tower.mouseIdlin();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;

        this.player.draw(g2D);
        this.tower.draw(g2D);
    }

    public int getTankN() {
        return this.tankN;
    }

}
