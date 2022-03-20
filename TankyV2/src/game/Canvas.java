package game;

import tools.EImages;
import tools.Image;

import javax.swing.*;
import java.awt.*;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Canvas extends JFrame {

    public Canvas() {
        this.canvasInit();
    }

    private void canvasInit() {
        this.setSize(400, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tanky v.2");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
        new Panel();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        super.paint(g);
        Image image = new Image(EImages.ICON.getImage());
        image.paint(g2d);
    }
}
