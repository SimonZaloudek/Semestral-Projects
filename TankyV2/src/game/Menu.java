package game;

import javax.swing.*;
import java.awt.Color;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Menu extends JFrame {

    public Menu() {
        this.menuInit();
    }

    private void menuInit() {
        this.setSize(400, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
    }

}
