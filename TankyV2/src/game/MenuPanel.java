package game;

import buttons.ButtonExit;
import buttons.ButtonHelp;
import buttons.ButtonSelection;
import tools.Canvas;
import tools.EImages;
import tools.Image;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class MenuPanel extends JPanel {

    private final Canvas canvas;

    private static final int WIDTH = 700;
    private static final int HEIGHT = 800;

    public MenuPanel(Canvas canvas) {
        this.panel(Color.BLACK, WIDTH, HEIGHT);

        this.canvas = canvas;
        super.setLayout(null);

        super.add(new ButtonSelection(100, 250, 210, 70, this));
        super.add(new ButtonHelp(100, 425, 210, 70, this));
        super.add(new ButtonExit(100, 600, 210, 70, this));
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
        image = new Image(EImages.getNum(new Random().nextInt(5) + 1).getImage());
        image.paint(g2D, 400, 350, 200, 250);
    }

    public void goToHelp() {
        super.removeAll();
        this.canvas.remove(this);
        this.canvas.add(new HelpPanel(this.canvas));
        this.canvas.pack();
    }

    public void goToSelection() {
        super.removeAll();
        this.canvas.remove(this);
        this.canvas.add(new SelectionPanel(this.canvas));
        this.canvas.pack();
        this.canvas.center();
    }
}
