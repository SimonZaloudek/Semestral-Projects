package game;

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
    private KeyHandler handler;
    private final Canvas canvas;

    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;

    public GamePanel(Canvas canvas) {
        this.panel(Color.WHITE, WIDTH, HEIGHT);

        this.canvas = canvas;
        this.handler = new KeyHandler();
        super.setLayout(null);
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
            this.update();
            super.repaint();
        }
    }

    public void update() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;
    }
}
