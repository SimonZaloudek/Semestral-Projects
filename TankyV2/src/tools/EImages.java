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
    //MenuAssets
    LOGO("assets/core/tankyLogo.png"),
    ICON("assets/core/tankyIcon.png"),
    BCG("assets/core/imgbcg.png"),
    HELP("assets/core/help.png"),
    BLEFT("assets/core/btnleft.png"),
    BRIGHT("assets/core/btnright.png"),
    //TankAssets
    TANK1("assets/tanks/tank1.png"),
    TANK2("assets/tanks/tank2.png"),
    TANK3("assets/tanks/tank3.png"),
    TANK4("assets/tanks/tank4.png"),
    TANK5("assets/tanks/tank5.png"),
    ENEMY1("assets/tanks/tankE1.png"),
    ENEMY2("assets/tanks/tankE2.png");

    private BufferedImage image;

    EImages(String path) {
        try {
            this.image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Faulty path dir -> " + path + " <- not found");
        }
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public static EImages getNum(int num) {
        if (num < 5 || num > 11) {
            num = 5;
        }
        return EImages.values()[num + 1];
    }
}
