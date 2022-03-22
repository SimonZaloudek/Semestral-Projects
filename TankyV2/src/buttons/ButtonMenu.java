package buttons;

import game.HelpPanel;
import game.SelectionPanel;
import tools.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class ButtonMenu extends Button {

    public ButtonMenu(int x, int y, int width, int height, String panel, SelectionPanel sPanel, HelpPanel hPanel) {
        super(x, y, width, height, "Menu");
        super.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panel.equals("help")) {
                    hPanel.goToMenu();
                } else if (panel.equals("selection")) {
                    sPanel.goToMenu();
                }
            }
        });
    }
}
