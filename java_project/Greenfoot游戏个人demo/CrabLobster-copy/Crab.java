import greenfoot.*;


public class Crab extends Animals
{
    /**
     * 螃蟹背景图片
     * 由于每一帧画面切换较快
     * 所以设置count 计数器
     * 每四次切换一次背景 实现肉眼上的螃蟹动态效果
     * */
    private GreenfootImage myImage = getImage();
    int count = 0;

    public void act()
    {
        count = (count + 1) % 3;// 模3取余 实现4次计数的循环
        
        // 左键按下 逆时针旋转角度
        if (Greenfoot.isKeyDown("left")) {
            this.turn(-5);
        }
        // 右键按下 顺时针旋转角度
        if (Greenfoot.isKeyDown("right")) {
            this.turn(5);
        }

        this.move(5);// 移动
        this.turnAtEdge();// 边界转向
        this.eat(); // 吃虫
        this.changeImage();// 背景图 动态
    }

    public void eat() {
        // 获取游戏场景对象
        CrabWorld nowWorld = this.getWorld();
        if (this.isTouching(Worm.class)) {
            this.removeTouching(Worm.class);
            Greenfoot.playSound("slurp.wav");

            //沙虫 分值 +1  刷新数据
            nowWorld.setScore(1);
            nowWorld.refreshBoard(nowWorld.score, nowWorld.life);
            
            // 分数值大于9 胜利
            if(nowWorld.score + 1 > 9) {
                nowWorld.refreshBoard(nowWorld.score, nowWorld.life);// 刷新界面数据
                nowWorld.initData();// 初始化所有数据
                nowWorld.setGameWin(); // 显示gamewin
                Greenfoot.playSound("fanfare.wav"); // 获胜音效
                nowWorld.removeCrab(); //移出螃蟹
            }
        }
        
    }

    // 更换螃蟹背景
    public void changeImage() {
        GreenfootImage newImageRight = new GreenfootImage("crab2.png");
        setImage(newImageRight);
        myImage = getImage();
        
        // 计数器记三次数 更换一次背景实现动态
        if(this.count == 2) {
            setImage("crab.png");
        }
    }

}
