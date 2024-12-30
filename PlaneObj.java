package src.com.obj;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

import src.com.GameWin;

public class PlaneObj extends GameObj {
    @Override
    public Image getImage() {
        return super.getImage();
    }

    public PlaneObj() {
        super();
    }

    public PlaneObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                PlaneObj.super.x = e.getX() - 125;
                PlaneObj.super.y = e.getY() - 125;
            }
        });       
    }
    
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
    }

    public boolean isColliding(GameObj other) {
        return this.getRec().intersects(other.getRec());
    }
    
}
