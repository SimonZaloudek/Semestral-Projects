package tools;

import game.Canvas;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Image {

    private static BufferedImage image = null;

    public static BufferedImage getImage(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("An error has occured..");
        }
        return image;
    }

    public static void draw(Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(image, x, y, width, height, new Canvas());
    }
}
