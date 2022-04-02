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
        this.paint(g, x, y, width, height, angle, 0);
    }

    public void paint(Graphics g, int x, int y, int width, int height, int angle, int off) {
        Graphics2D g2D = (Graphics2D)g;
        BufferedImage im = new BufferedImage(width + off, height + off, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gd = im.createGraphics();

        AffineTransform at = new AffineTransform();
        at.rotate(Math.toRadians(angle), (width + off) / 2, (height + off) / 2);
        gd.transform(at);
        gd.drawImage(this.image, off / 2, off / 2, width, height, null);
        g2D.drawImage(im, x, y, null);
    }
}
