package buttons;

import game.HelpPanel;
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
public class ButtonMenu extends Button {

    public ButtonMenu(int x, int y, int width, int height, String text, boolean img, JPanel panel) {
        super(x, y, width, height, text);
        if (img) {
            super.setIcon(new ImageIcon(EImages.LOGO2.getImage()));
            super.setBorderPainted(false);
        }
        super.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panel instanceof HelpPanel) {
                    ((HelpPanel)panel).goToMenu();
                } else if (panel instanceof SelectionPanel) {
                    ((SelectionPanel)panel).goToMenu();
                } else if (panel instanceof MapSelectionPanel) {
                    ((MapSelectionPanel)panel).goToMenu();
                }
            }
        });
    }
}
