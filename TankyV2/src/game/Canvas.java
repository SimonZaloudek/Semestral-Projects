package game;

import tools.EImages;
import javax.swing.JFrame;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Canvas extends JFrame {

    public Canvas() {
        MenuPanel panel = new MenuPanel(this);

        super.setTitle("Tanky v.2");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setIconImage(EImages.ICON.getImage());
        super.setLocationRelativeTo(null);
        super.setResizable(true);
        super.setVisible(true);

        super.add(panel);
        super.pack();
    }
}
