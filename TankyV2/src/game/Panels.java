package game;

import tools.EImages;
import tools.Image;

import javax.swing.JPanel;
import java.awt.*;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Panels extends JPanel {

    private JPanel panel;

    public Panels(String name) {
        if (name.equals("menu")) {
            this.panel(Color.BLACK, 600, 800);
        } else if (name.equals("game")) {
            this.panel(Color.WHITE, 1080, 1920);
        }
    }

    public void panel(Color color, int width, int height) {
        this.panel = new JPanel();
        this.panel.setBackground(color);
        this.panel.setSize(width, height);
    }

    public JPanel getPanel() {
        return this.panel;
    }
}
