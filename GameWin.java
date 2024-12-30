package src.com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import src.com.obj.BgObj;
import src.com.obj.EnemyObj;
import src.com.obj.PlaneObj;
import src.com.obj.ShellObj;
import src.com.utils.GameUtils;

public class GameWin extends JFrame {

    static int state = 0;

    Image offScreenImage = null;
    int width = 1600, height = 900, count = 1;

    BgObj bgobj = new BgObj(GameUtils.bgImg, 0, 0, 2);

    PlaneObj planeObj = new PlaneObj(GameUtils.planeImg, 290, 550, 20, 30, 0, this);
    
    public void launch() {
        // 顯示視窗
        this.setVisible(true);
        // 設置視窗大小
        this.setSize(width, height);
        // 視窗出現位置
        this.setLocationRelativeTo(null);
        // 視窗標題
        this.setTitle("Vertical Scrolling Game");

        GameUtils.gameObjList.add(bgobj);
        GameUtils.gameObjList.add(planeObj);

        //滑鼠點擊觸發開始
        this.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e) {
            if (e.getButton() == 1 && state == 0) {
                state = 1;
                repaint();
            }
           } 

        });
        while (true) {
            if (state == 1) {
                createObj();
                repaint();
            }
           
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(width, height);
        }
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0, 0, 1600, 900);
        if (state == 0) {
            gImage.drawImage(GameUtils.bgImg, 0, 0, null);
            gImage.drawImage(GameUtils.bossImg, 650, 120, null);
            gImage.drawImage(GameUtils.ExplodeImg, 650, 500, null);
            gImage.setColor(Color.white);
            gImage.setFont(new Font("Courier new", Font.BOLD, 80));
            gImage.drawString("Press To Start", 475, 500);
        }
        if (state == 1) {
            for (int i = 0; i < GameUtils.gameObjList.size(); i++) {
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
            GameUtils.gameObjList.removeAll(GameUtils.RemoveList);
            
        }
        g.drawImage(offScreenImage, 0, 0, null);
        count++;
    }

    void createObj() {
        if (count % 10 == 0) {
            GameUtils.shellObjList.add(new ShellObj(GameUtils.bulletImg, planeObj.getx() + 50, planeObj.gety() - 16, 14, 29, 5, this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
        }
        if (count % 8 == 0) {
            GameUtils.enemyObjsList.add(new EnemyObj(GameUtils.enemyImg, (int) (Math.random() * 8) * 200, 0, 100, 100, 5, this));
            GameUtils.gameObjList.add(GameUtils.enemyObjsList.get(GameUtils.enemyObjsList.size() - 1));
        }    
    }

    public static void main(String[] args) {
        GameWin game = new GameWin();
        game.launch();
    }
}
