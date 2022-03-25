package buttons;

import game.MapSelectionPanel;
import game.SelectionPanel;
import tools.Button;
import tools.EImages;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class ButtonTankSelection extends Button {
    public ButtonTankSelection(int x, int y, int width, int height, String text, boolean right, JPanel panel) {
        super(x, y, width, height, text);
        super.setBorderPainted(false);
        if (right) {
            super.setIcon(new ImageIcon(EImages.BRIGHT.getImage()));
        } else {
            super.setIcon(new ImageIcon(EImages.BLEFT.getImage()));
        }

        super.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panel instanceof SelectionPanel) {
                    ((SelectionPanel)panel).changeNum(right);

                } else if (panel instanceof MapSelectionPanel) {
                    ((MapSelectionPanel)panel).changeNum(right);
                }
            }
        });
    }
}
