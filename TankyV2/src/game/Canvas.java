package game;

import javax.swing.JFrame;
import java.awt.Color;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Canvas extends JFrame {

    public Canvas() {
        this.canvasInit();
    }

    private void canvasInit() {
        this.setSize(400, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tanky v.2");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
    }
}
