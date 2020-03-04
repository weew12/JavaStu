import greenfoot.*;
import java.lang.*;


public class Lobster extends Animals
{
    public void act()
    {  
        this.turnAtEdge();// 边界转向
        this.move(5);// 移动
        this.eat();// eat
        // 运动随机
        if(this.getRandomNumber(100) < 10) {
            this.turn(5);
        }
    }
    
    public void eat() {
        CrabWorld nowWorld = this.getWorld();
        if (this.isTouching(Crab.class)) {
            
            Greenfoot.playSound("au.wav"); // 声效
            nowWorld.resetCrabPosition(); // 重置螃蟹位置 模拟螃蟹复活
            
            // 生命值 -1 刷新数据
            nowWorld.setLife(1);
            nowWorld.refreshBoard(nowWorld.score, nowWorld.life);
            
            // 复活过程的短暂延时
            Greenfoot.stop();
            try {
               Thread.sleep(150); 
            } catch(Exception e) {}
            Greenfoot.start();
            
            // 生命值耗尽游戏结束
            if (nowWorld.life - 1 < 0) {
                nowWorld.refreshBoard(nowWorld.score, nowWorld.life);// 刷新数据
                nowWorld.initData();// 初始化所有数据
                nowWorld.removeCrab();//移出螃蟹
                nowWorld.setGameOver();// 显示gameover
                Greenfoot.stop();
            }
        }
    }

}
