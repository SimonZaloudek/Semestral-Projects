package game;

import tools.EImages;
import tools.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Canvas extends JFrame {

    private JPanel panel;

    public Canvas() {
        this.canvasInit();
    }

    private void canvasInit() {
        this.panel = new JPanel();
        this.panel.setBackground(Color.black);
        this.pack();
        this.add(this.panel);

        this.setSize(400, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tanky v.2");
        this.setResizable(true);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        this.panel.paint(g2d);
        Image image = new Image(EImages.ICON.getImage());
        image.paint(g2d);
    }
}
