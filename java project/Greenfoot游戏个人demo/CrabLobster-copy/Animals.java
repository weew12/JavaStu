import greenfoot.*;


public class Animals extends Actor
{
    // 执行动作
    // public void act() {}
    
    // 获取CrabWorld引用
    public CrabWorld getWorld(){
        return (CrabWorld)(super.getWorld());
    }
    
    // eat方法
    public void eat() {}
    
    // 获取随机数
    public int getRandomNumber(int area) {
        return Greenfoot.getRandomNumber(area);
    }
    
    // 检测是否到边界 到边界自动转向
    public void turnAtEdge() {
        boolean atEdge = this.isAtEdge();
        // 随机转向
        if (atEdge) {
            int turnDeg = this.getRandomNumber(45);
            this.turn(turnDeg);
        }
    }
    
}
