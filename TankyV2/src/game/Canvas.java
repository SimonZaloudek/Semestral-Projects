package game;

import tools.EImages;
import tools.Image;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Canvas extends JFrame {

    private Panels menu;

    public Canvas() {
        this.canvasInit();
    }

    private void canvasInit() {
        this.menu = new Panels("menu");
        this.add(this.menu.getPanel());

        this.setSize(600, 800);
        this.setIconImage(EImages.ICON.getImage());
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tanky v.2");
        this.setResizable(false);
        this.setVisible(true);
        //this.goToGame();
    }

    public void goToGame() {
        this.remove(this.menu.getPanel());
        this.pack();
        this.menu = new Panels("game");
        this.add(this.menu.getPanel());
        this.setSize(1600, 900);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        this.menu.getPanel().paint(g2d);
        tools.Image image = new Image(EImages.LOGO.getImage());
        image.paint(g2d, 40, 30, 500, 120);
    }
}
