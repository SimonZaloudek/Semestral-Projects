package buttons;

import game.MapSelectionPanel;
import game.MenuPanel;
import game.SelectionPanel;
import tools.Button;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class ButtonSelection extends Button {

    public ButtonSelection(int x, int y, int width, int height, String text, JPanel panel) {
        super(x, y, width, height, text);
        super.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panel instanceof SelectionPanel) {
                    ((SelectionPanel)panel).goToMapSelection();
                } else if (panel instanceof MenuPanel) {
                    ((MenuPanel)panel).goToSelection();
                } else if (panel instanceof MapSelectionPanel) {
                    ((MapSelectionPanel)panel).goToSelection();
                }
            }
        });
    }
}
