package tools;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Image {

    private BufferedImage image;

    public Image(BufferedImage image) {
        this.image = image;
    }

    public void paint(Graphics g, int x, int y, int width, int height) {
        g.drawImage(this.image, x, y, width, height, null);
    }
}
