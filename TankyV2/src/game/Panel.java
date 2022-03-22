package game;

import buttons.ButtonExit;
import buttons.ButtonHelp;
import buttons.ButtonStart;
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
public class Panel extends JPanel implements Runnable {

    private Thread thread;
    private KeyHandler handler;
    private final Canvas canvas;
    private Image image;

    private static final int WIDTH = 700;
    private static final int HEIGHT = 800;

    public Panel(Canvas canvas) {
        this.panel(Color.BLACK, WIDTH, HEIGHT);

        this.canvas = canvas;
        this.handler = new KeyHandler();
        super.setLayout(null);

        super.add(new ButtonStart(100, 250, 210, 70, this));
        super.add(new ButtonHelp(100, 425, 210, 70, this));
        super.add(new ButtonExit(100, 600, 210, 70, this));
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

        this.image = new Image(EImages.LOGO.getImage());
        this.image.paint(g2D, WIDTH / 2 - 550 / 2, 40, 550, 130);
        this.image = new Image(EImages.TANK1.getImage());
        this.image.paint(g2D, 450, 350, 200, 250);
    }

    public void goToGame() {
        super.removeAll();
        this.panel(Color.WHITE, 1600, 900);
        this.canvas.pack();
    }

    public void goToHelp() {
        super.removeAll();
        this.panel(Color.BLACK, 400, 400);
        this.canvas.pack();
    }
}
