package src.com.obj;
import java.awt.*;

import src.com.GameWin;
import src.com.utils.GameUtils;

public class EnemyObj extends GameObj {
    
    public EnemyObj() {
        super();
    }

    public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }
    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        for (ShellObj shellObj : GameUtils.shellObjList) {
            if (this.getRec().intersects(shellObj.getRec())) {
                shellObj.setx(-100);
                shellObj.sety(100);
                this.x = -200;
                this.y = 200;
                GameUtils.RemoveList.add(shellObj);
                GameUtils.RemoveList.add(this);
            }
        }
    }
        

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

    
    
}
