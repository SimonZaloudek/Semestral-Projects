package tools;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Image extends JPanel {

    private BufferedImage image;

    public Image(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void paint(Graphics g) {
        g.drawImage(this.image, 0, 0, this);
    }
}
