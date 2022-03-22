package buttons;

import game.MenuPanel;
import tools.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class ButtonSelection extends Button {

    public ButtonSelection(int x, int y, int width, int height, MenuPanel panel) {
        super(x, y, width, height, "Selection");
        super.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.goToSelection();
            }
        });
    }
}
