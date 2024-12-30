package src.com.obj;

import java.awt.Graphics;
import java.awt.Image;

public class BgObj extends GameObj {
    public BgObj() {
        super();
    }

    public BgObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImages) {
        // 繪製當前背景
        gImages.drawImage(img, x, y, null);
        // 繪製下一個背景，用於無縫銜接
        gImages.drawImage(img, x, y - img.getHeight(null), null);

        // 更新背景位置
        y += speed;

        // 如果當前背景完全移出屏幕，重置其位置
        if (y >= img.getHeight(null)) {
            y = 0;
        }
    }
}
