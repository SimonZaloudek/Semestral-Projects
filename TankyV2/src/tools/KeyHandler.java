package tools;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class KeyHandler implements KeyListener {

    private boolean w, a, s, d;

    @Override
    public void keyTyped(KeyEvent e) {
        //Nothing xd
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W -> this.w = true;
            case KeyEvent.VK_A -> this.a = true;
            case KeyEvent.VK_S -> this.s = true;
            case KeyEvent.VK_D -> this.d = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W -> this.w = false;
            case KeyEvent.VK_A -> this.a = false;
            case KeyEvent.VK_S -> this.s = false;
            case KeyEvent.VK_D -> this.d = false;
        }
    }

    public boolean isW() {
        return this.w;
    }

    public boolean isA() {
        return this.a;
    }

    public boolean isS() {
        return this.s;
    }

    public boolean isD() {
        return this.d;
    }
}
