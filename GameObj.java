package src.com.obj;
import java.awt.*;

import src.com.GameWin;

public class GameObj {
    Image img;
    int x, y, width, height;
    double speed;
    GameWin frame;

    public Image getImage() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getx() {
        return x;
    }

    public void setx(int x) {
        this.x = x;
    }

    public int gety() {
        return y;
    }

    public void sety(int y) {
        this.y = y;
    }

    public int getwidth() {
        return width;
    }

    public void setwidth(int width) {
        this.width = width;
    }

    public int getheight() {
        return height;
    }

    public void setheight(int height) {
        this.height = height;
    }

    public double getspeed() {
        return speed;
    }

    public void setspeed(double speed) {
        this.speed = speed;
    }

    public GameWin getFrame() {
        return frame;
    }

    public void setFrame(GameWin frame) {
        this.frame = frame;
    }

    public GameObj() {
    }

    public GameObj(Image img, int x, int y, double speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public GameObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = frame;
    }

    public void paintSelf(Graphics gImage) {
        gImage.drawImage(img, x, y, null);
    }

    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }
}
