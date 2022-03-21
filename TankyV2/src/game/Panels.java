package game;

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
public class Panels extends JPanel implements Runnable {

    private Thread thread;

    public Panels(String name) {
        if (name.equals("menu")) {
            this.panel(Color.BLACK, 600, 800);
        } else if (name.equals("game")) {
            this.panel(Color.WHITE, 900, 1600);
        }
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

        g2D.setColor(Color.YELLOW);
        g2D.fillRect(0, 0, 48, 48);
        g2D.dispose();
    }
}
