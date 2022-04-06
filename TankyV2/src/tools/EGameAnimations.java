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
public enum EGameAnimations {

    //TankBodies
    BODY1("assets/tanks/inGame/tank1.png"),
    BODY2("assets/tanks/inGame/tank2.png"),
    BODY3("assets/tanks/inGame/tank3.png"),
    BODY4("assets/tanks/inGame/tank4.png"),
    BODY5("assets/tanks/inGame/tank5.png");

    private BufferedImage image;

    EGameAnimations(String path) {
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

    public static EGameAnimations getNum(int num) {
        if (num < 0 || num > 4) {
            num = 0;
        }
        return EGameAnimations.values()[num];
    }
}
