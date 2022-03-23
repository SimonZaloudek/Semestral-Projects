package game;

import buttons.ButtonMenu;
import tools.Canvas;
import tools.EImages;
import tools.Image;

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
public class HelpPanel extends JPanel {

    private final Canvas canvas;

    private static final int WIDTH = 700;
    private static final int HEIGHT = 800;

    public HelpPanel(Canvas canvas) {
        this.panel(Color.BLACK, WIDTH, HEIGHT);

        this.canvas = canvas;
        super.setLayout(null);

        super.add(new ButtonMenu(WIDTH / 2 - 250 / 2, 200, 200, 60, this));
    }

    public void panel(Color color, int width, int height) {
        super.setBackground(color);
        super.setPreferredSize(new Dimension(width, height));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;

        Image image = new Image(EImages.LOGO.getImage());
        image.paint(g2D, WIDTH / 2 - 550 / 2, 40, 550, 130);
        this.revalidate();
    }

    public void goToMenu() {
        super.removeAll();
        this.canvas.remove(this);
        this.canvas.add(new MenuPanel(this.canvas));
        this.canvas.pack();
    }
}
