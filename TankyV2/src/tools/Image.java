package tools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;


/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Image {

    private final BufferedImage image;

    public Image(BufferedImage image) {
        this.image = image;
    }

    public void paint(Graphics g, int x, int y, int width, int height, int angle) {
        Graphics2D g2D = (Graphics2D)g;
        BufferedImage im = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gd = im.createGraphics();

        AffineTransform at = new AffineTransform();
        at.rotate(Math.toRadians(angle), width / 2, height / 2);
        gd.transform(at);
        gd.drawImage(this.image, 0, 0, width, height, null);

        g2D.drawImage(im, x, y, null);
    }
}
