package buttons;

import game.Panel;
import tools.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class ButtonHelp extends Button {

    public ButtonHelp(int x, int y, int width, int height, Panel panel) {
        super(x, y, width, height, "Help");
        super.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.goToHelp();
            }
        });
    }
}
