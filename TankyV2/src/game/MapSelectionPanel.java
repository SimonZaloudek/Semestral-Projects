package game;

import buttons.ButtonMenu;
import buttons.ButtonSelection;
import buttons.ButtonStart;
import tools.Canvas;

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
public class MapSelectionPanel extends JPanel {

    private final Canvas canvas;

    private static final int WIDTH = 700;
    private static final int HEIGHT = 800;

    public MapSelectionPanel(Canvas canvas) {
        this.panel(Color.BLACK, WIDTH, HEIGHT);

        this.canvas = canvas;
        super.setLayout(null);

        //Buttons
        super.add(new ButtonStart(420, 579, 210, 70, "START", this));
        super.add(new ButtonMenu(WIDTH / 2 - 600 / 2, 40, 600, 150, "", true, this));
        super.add(new ButtonSelection(75, 579, 210, 70, "BACK", this));
    }

    public void panel(Color color, int width, int height) {
        super.setBackground(color);
        super.setPreferredSize(new Dimension(width, height));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;

//        Image image = new Image(EImages.LOGO.getImage());
//        image.paint(g2D, WIDTH / 2 - 550 / 2, 40, 600, 150);
    }

    public void goToSelection() {
        super.removeAll();
        this.canvas.add(new SelectionPanel(this.canvas));
        this.canvas.panelConfig(this);
    }

    public void goToGame() {
        super.removeAll();
        this.canvas.add(new GamePanel(this.canvas));
        this.canvas.panelConfig(this);
    }

    public void goToMenu() {
        super.removeAll();
        this.canvas.add(new MenuPanel(this.canvas));
        this.canvas.panelConfig(this);
    }
}
