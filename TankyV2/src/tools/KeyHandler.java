package tools;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class KeyHandler implements KeyListener {

    private ArrayList<KeyEvent> keys = new ArrayList<>();

    @Override
    public void keyTyped(KeyEvent e) {
        //Nothing xd
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D -> this.keys.add(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D -> this.keys.remove(e);
        }
    }
}
