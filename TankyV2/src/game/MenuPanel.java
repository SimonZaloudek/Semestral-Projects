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
    private boolean isPainted;
    private int num = 0;

    private static final int WIDTH = 700;
    private static final int HEIGHT = 800;

    public MenuPanel(Canvas canvas) {
        this.panel(Color.BLACK, WIDTH, HEIGHT);

        this.canvas = canvas;
        super.setLayout(null);

        //Buttons
        super.add(new ButtonSelection(75, 300, 210, 70, "PLAY", this));
        super.add(new ButtonHelp(75, 439, 210, 70, "HELP", this));
        super.add(new ButtonExit(75, 579, 210, 70, "EXIT"));
    }

    public void panel(Color color, int width, int height) {
        super.setBackground(color);
        super.setPreferredSize(new Dimension(width, height));
    }

    public void paintComponent(Graphics g) {
        if (!this.isPainted) {
            this.isPainted = true;
            Random random = new Random();
            this.num = random.nextInt(12 - 5) + 5;
        }

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;

        //Logo
        Image image = new Image(EImages.LOGO.getImage());
        image.paint(g2D, WIDTH / 2 - 600 / 2, 40, 600, 150, 0);
        //Oramovanie
        image = new Image(EImages.BCG.getImage());
        image.paint(g2D, 325, 300, 310, 350, 0);
        //Tanky
        image = new Image(EImages.getNum(this.num, false).getImage());
        image.paint(g2D, 375, 350, 210, 250, 0);
    }

    public void goToHelp() {
        super.removeAll();
        this.canvas.add(new HelpPanel(this.canvas));
        this.canvas.panelConfig(this);
    }

    public void goToSelection() {
        super.removeAll();
        this.canvas.add(new SelectionPanel(this.canvas));
        this.canvas.panelConfig(this);

    }
}
