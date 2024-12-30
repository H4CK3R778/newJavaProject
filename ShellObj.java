package src.com.obj;
import java.awt.*;
import src.com.GameWin;

public class ShellObj extends GameObj{
    @Override
    public Image getImage() {
        return super.getImage();
    }

    public ShellObj() {
        super();
    }

    public ShellObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);       
    }
    
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y -= speed;
    }

    public boolean isColliding(GameObj other) {
        return this.getRec().intersects(other.getRec());
    }
}
