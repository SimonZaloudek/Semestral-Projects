package tools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public enum EImages {
    LOGO("assets/tankyLogo.png"),
    ICON("assets/tankyIcon.png");

    private BufferedImage image;

    EImages(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public BufferedImage getImage() {
        return image;
    }
}
