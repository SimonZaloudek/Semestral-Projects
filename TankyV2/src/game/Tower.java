package game;

import entities.Player;
import tools.EImages;
import tools.Image;
import tools.KeyHandler;
import tools.MouseHandler;

import java.awt.Graphics2D;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Tower extends Player {

    private MouseHandler m;

    public Tower(GamePanel p, KeyHandler h, MouseHandler m) {
        super(p, h);
        this.m = m;
    }

    public void draw(Graphics2D g2D) {
        super.update();

        Image image = new Image(EImages.getTower(super.getPanel().getTankN() + 7).getImage());
        image.paint(g2D, super.getX() - 6, super.getY() - 7, 87, 104, (int)this.m.getAngleM(), 40);
    }
}
