package game;

import buttons.ButtonMenu;
import buttons.ButtonSelection;
import buttons.ButtonTankSelection;
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
public class SelectionPanel extends JPanel {

    private final Canvas canvas;

    private static final int WIDTH = 700;
    private static final int HEIGHT = 800;
    private int num = 1;

    public SelectionPanel(Canvas canvas) {
        this.panel(Color.BLACK, WIDTH, HEIGHT);

        this.canvas = canvas;
        super.setLayout(null);

        //Buttons
        super.add(new ButtonSelection(420, 579, 210, 70, "CONTINUE", this));
        super.add(new ButtonMenu(75, 579, 210, 70, "BACK", false, this));
        super.add(new ButtonMenu(WIDTH / 2 - 600 / 2, 40, 600, 150, "", true, this));

        super.add(new ButtonTankSelection(75, 385, 100, 55, "", false, this));
        super.add(new ButtonTankSelection(530, 385, 100, 55, "", true, this));
    }

    public void panel(Color color, int width, int height) {
        super.setBackground(color);
        super.setPreferredSize(new Dimension(width, height));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;

        if (this.num > 9) {
            this.num = 9;
        } else if (this.num < 5) {
            this.num = 5;
        }

        //Oramovanie
        Image image = new Image(EImages.BCG.getImage());
        image.paint(g2D, WIDTH / 2 - 310 / 2, 210, 310, 350, 0);
        //Tanky
        image = new Image(EImages.getNum(this.num, false).getImage());
        image.paint(g2D, WIDTH / 2 - 210 / 2, 260, 210, 250, 0);
    }

    public void goToMenu() {
        super.removeAll();
        this.canvas.add(new MenuPanel(this.canvas));
        this.canvas.panelConfig(this);
    }

    public void goToMapSelection() {
        super.removeAll();
        this.canvas.add(new MapSelectionPanel(this.canvas));
        this.canvas.panelConfig(this);
        this.canvas.setTankN(this.num);
    }

    public void changeNum(boolean right) {
        if (right) {
            this.num++;
        } else {
            this.num--;
        }
        this.repaint();
    }
}

