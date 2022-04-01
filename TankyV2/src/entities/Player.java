package entities;

import game.GamePanel;
import tools.EImages;
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
    private int speed;
    private int angle;

    public Player(GamePanel p, KeyHandler h) {
        this.panel = p;
        this.handler = h;
        
        this.setSpawnLocation();
    }

    public void setSpawnLocation() {
        this.x = 400;
        this.y = 400;
        this.speed = 3;
    }

    public void update() {
        if (this.handler.isW() && !this.handler.isA() && !this.handler.isS() && !this.handler.isD()) {
            this.y -= this.speed;
            this.angle = 0;
        }
        if (this.handler.isA() && !this.handler.isW() && !this.handler.isS() && !this.handler.isD()) {
            this.x -= this.speed;
            this.angle = -90;
        }
        if (this.handler.isS() && !this.handler.isA() && !this.handler.isW() && !this.handler.isD()) {
            this.y += this.speed;
            this.angle = 180;
        }
        if (this.handler.isD() && !this.handler.isA() && !this.handler.isS() && !this.handler.isW()) {
            this.x += this.speed;
            this.angle = 90;
        }
        if (this.handler.isW() && this.handler.isD() && !this.handler.isS() && !this.handler.isA()) {
            this.x += this.speed - 1;
            this.y -= this.speed - 1;
            this.angle = 45;
        }
        if (this.handler.isW() && this.handler.isA() && !this.handler.isS() && !this.handler.isD()) {
            this.x -= this.speed - 1;
            this.y -= this.speed - 1;
            this.angle = -45;
        }
        if (this.handler.isS() && this.handler.isD() && !this.handler.isA() && !this.handler.isW()) {
            this.x += this.speed - 1;
            this.y += this.speed - 1;
            this.angle = 135;
        }
        if (this.handler.isS() && this.handler.isA() && !this.handler.isW() && !this.handler.isD()) {
            this.x -= this.speed - 1;
            this.y += this.speed - 1;
            this.angle = 225;
        }
    }

    public void draw(Graphics2D g2D) {
        Image image = new Image(EImages.getNum(this.panel.getTankN()).getImage());
        image.paint(g2D, this.x, this.y, 75, 90, this.angle, 40);
    }
}
