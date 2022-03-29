package game;

import tools.Canvas;
import tools.EImages;
import tools.Image;
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
    private final KeyHandler handler;
    private final Canvas canvas;

    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;

    private int playerX = 50;
    private int playerY = 50;
    private int angle = 0;
    private int playerSpeed = 3;

    private long lastFrame;

    public GamePanel(Canvas canvas) {
        this.panel(Color.WHITE, WIDTH, HEIGHT);

        this.canvas = canvas;
        this.handler = new KeyHandler();
        super.setLayout(null);

        super.addKeyListener(this.handler);
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
        }
    }

    public void update() {
        if (this.handler.isW() && !this.handler.isA() && !this.handler.isS() && !this.handler.isD()) {
            this.playerY -= this.playerSpeed;
            this.angle = 0;
        }
        if (this.handler.isA() && !this.handler.isW() && !this.handler.isS() && !this.handler.isD()) {
            this.playerX -= this.playerSpeed;
            this.angle = -90;
        }
        if (this.handler.isS() && !this.handler.isA() && !this.handler.isW() && !this.handler.isD()) {
            this.playerY += this.playerSpeed;
            this.angle = 180;
        }
        if (this.handler.isD() && !this.handler.isA() && !this.handler.isS() && !this.handler.isW()) {
            this.playerX += this.playerSpeed;
            this.angle = 90;
        }
        if (this.handler.isW() && this.handler.isD() && !this.handler.isS() && !this.handler.isA()) {
            this.playerX += this.playerSpeed - 1;
            this.playerY -= this.playerSpeed - 1;
            this.angle = 45;
        }
        if (this.handler.isW() && this.handler.isA() && !this.handler.isS() && !this.handler.isD()) {
            this.playerX -= this.playerSpeed - 1;
            this.playerY -= this.playerSpeed - 1;
            this.angle = -45;
        }
        if (this.handler.isS() && this.handler.isD() && !this.handler.isA() && !this.handler.isW()) {
            this.playerX += this.playerSpeed - 1;
            this.playerY += this.playerSpeed - 1;
            this.angle = 135;
        }
        if (this.handler.isS() && this.handler.isA() && !this.handler.isW() && !this.handler.isD()) {
            this.playerX -= this.playerSpeed - 1;
            this.playerY += this.playerSpeed - 1;
            this.angle = 225;
        }
        super.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;

        Image image = new Image(EImages.getNum(this.canvas.getTankN()).getImage());
        image.paint(g2D, this.playerX, this.playerY, 75, 90, this.angle, 40);
    }
}
