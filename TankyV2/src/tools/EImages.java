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
    ICON("assets/tankyIcon.png"),
    TANK1("assets/tank1.png"),
    TANK2("assets/tank2.png"),
    TANK3("assets/tank3.png"),
    TANK4("assets/tank4.png"),
    TANK5("assets/tank5.png");

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
