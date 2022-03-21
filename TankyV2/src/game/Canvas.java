package game;

import tools.EImages;
import tools.Image;

import javax.swing.JFrame;

import java.awt.*;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Canvas extends JFrame {

    private Panels panel;

    public Canvas() {
        this.canvasInit();
    }

    private void canvasInit() {
        super.setTitle("Tanky v.2");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setIconImage(EImages.ICON.getImage());
        super.setLocationRelativeTo(null);
        super.setResizable(true);
        super.setVisible(true);

        this.panel = new Panels("menu");
        super.add(this.panel);

        super.setSize(new Dimension(600, 800));

        this.panel.startTread();
        //this.goToGame();
    }

    public void goToGame() {
        this.remove(this.panel);
        this.pack();
        this.panel = new Panels("game");
        this.add(this.panel);
        this.setSize(1600, 900);
    }

    /*public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        this.menu.getPanel().paint(g2d);
        tools.Image image = new Image(EImages.LOGO.getImage());
        image.paint(g2d, 30, 40, 550, 130);
    }
     */
}
