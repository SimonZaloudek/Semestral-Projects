package entities;

import game.GamePanel;
import tools.EGameAnimations;
import tools.Image;
import tools.KeyHandler;

import java.awt.Graphics2D;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public class Player {

    private final KeyHandler handler;
    private final GamePanel panel;
    private int x;
    private int y;
    private int angle;

    public Player(GamePanel p, KeyHandler h) {
        this.panel = p;
        this.handler = h;
        
        this.setSpawnLocation();
    }

    public void setSpawnLocation() {
        this.x = 400;
        this.y = 400;
    }

    public void update(int speed) {
        if (this.handler.isW() && !this.handler.isA() && !this.handler.isS() && !this.handler.isD()) {
            this.y -= speed;
            this.angle = 0;
        }
        if (this.handler.isA() && !this.handler.isW() && !this.handler.isS() && !this.handler.isD()) {
            this.x -= speed;
            this.angle = -90;
        }
        if (this.handler.isS() && !this.handler.isA() && !this.handler.isW() && !this.handler.isD()) {
            this.y += speed;
            this.angle = 180;
        }
        if (this.handler.isD() && !this.handler.isA() && !this.handler.isS() && !this.handler.isW()) {
            this.x += speed;
            this.angle = 90;
        }
        if (this.handler.isW() && this.handler.isD() && !this.handler.isS() && !this.handler.isA()) {
            this.y -= speed - 1;
            this.x += speed - 1;
            this.angle = 45;
        }
        if (this.handler.isW() && this.handler.isA() && !this.handler.isS() && !this.handler.isD()) {
            this.x -= speed - 1;
            this.y -= speed - 1;
            this.angle = -45;
        }
        if (this.handler.isS() && this.handler.isD() && !this.handler.isA() && !this.handler.isW()) {
            this.x += speed - 1;
            this.y += speed - 1;
            this.angle = 135;
        }
        if (this.handler.isS() && this.handler.isA() && !this.handler.isW() && !this.handler.isD()) {
            this.x -= speed - 1;
            this.y += speed - 1;
            this.angle = 225;
        }
    }

    public void draw(Graphics2D g2D) {
        Image image = new Image(EGameAnimations.getNum(this.panel.getTankN() - 5).getImage());
        image.paint(g2D, this.x, this.y, 75, 90, this.angle, 40);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public GamePanel getPanel() {
        return this.panel;
    }
}
