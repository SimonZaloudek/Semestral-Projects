package tools;

import game.MenuPanel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Canvas extends JFrame {

    private int counter = 0;

    public Canvas() {
        //Canvas Init.
        super.setTitle("Tanky v.2");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setIconImage(EImages.ICON.getImage());
        super.setResizable(false);
        super.setVisible(true);

        //MenuPanel Init.
        MenuPanel panel = new MenuPanel(this);
        super.add(panel);
        super.pack();
        
        this.panelConfig(panel);
    }

    public void panelConfig(JPanel panel) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        if (this.counter > 0) {
            this.remove(panel);
            this.pack();
        }
        this.counter++;
        this.setLocation(dim.width / 2 - super.getSize().width / 2, dim.height / 2 - super.getSize().height / 2);
    }
}
