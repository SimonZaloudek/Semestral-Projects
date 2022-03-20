package tools;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Image {

    private BufferedImage image;

    public BufferedImage getImage() {
        this.image = EImages.ICON.getImage();
        return this.image;
    }

    public void draw(Graphics2D g, int x, int y, int width, int height) {
        g.drawImage(this.getImage(), x, y, width, height, null);
    }
}
