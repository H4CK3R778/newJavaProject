package src.com.utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import src.com.obj.EnemyObj;
import src.com.obj.GameObj;
import src.com.obj.ShellObj;


public class GameUtils {
    //背景圖片(Bug)
    public static Image bgImg = Toolkit.getDefaultToolkit().getImage("imgs/bgImg.jpg");
    //boss圖片
    public static Image bossImg = Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
    //爆炸圖片
    public static Image ExplodeImg = Toolkit.getDefaultToolkit().getImage("imgs/explode.png");
    //Plane
    public static Image planeImg = Toolkit.getDefaultToolkit().getImage("imgs/plane.png");
    //Bullet
    public static Image bulletImg = Toolkit.getDefaultToolkit().getImage("imgs/bullet.png");
    // Enemy
    public static Image enemyImg = Toolkit.getDefaultToolkit().getImage("imgs/enemy.png");
    //遊戲物體集合
    public static List<GameObj> gameObjList = new ArrayList<>();
    //要刪除物體的集合
    public static List<GameObj> RemoveList = new ArrayList<>();
    //子彈集合
    public static List<ShellObj> shellObjList = new ArrayList<>();
    //敵人集合
    public static List<EnemyObj> enemyObjsList = new ArrayList<>();
}
