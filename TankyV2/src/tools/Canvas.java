package tools;

import game.MenuPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

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
        super.setResizable(false);
        super.setVisible(true);

        super.add(panel);
        super.pack();

        this.center();
    }

    public void center() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - super.getSize().width / 2, dim.height / 2 - super.getSize().height / 2);
    }
}
