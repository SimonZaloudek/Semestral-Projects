package tools;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Button extends JButton {

    public Button(int x, int y, int width, int height, String text) {
        super.setBounds(x, y, width, height);
        super.setText(text);
        super.setFont(new Font("Tahoma", Font.BOLD, 25));
        super.setBackground(Color.WHITE);
        super.setForeground(Color.BLACK);
        super.setBorder(new LineBorder(Color.RED.darker(), 4));
    }
}
