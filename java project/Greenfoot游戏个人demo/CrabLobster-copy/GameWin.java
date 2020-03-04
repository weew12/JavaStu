import greenfoot.*; 
import greenfoot.Font;


/**
 * 当螃蟹吃掉9个沙虫 螃蟹获胜
 * 游戏结束 弹出 GameWin界面
 */
public class GameWin extends SettingScreen {

    public GameWin() {}

    // 绘制记录区域img
    public GreenfootImage img = super.getAnGreenfootImage(600, 600);

    // 绘制gameOver
    public void draw() {
        // 颜色填充
        img.setColor(super.BACKGROUND);
        img.fill();
        img.setColor(super.FOREGROUND);

        // 画边框
        img.drawRect(0+3,0+3,img.getWidth()-6, img.getHeight()-6);
        img.drawRect(1+3,1+3,img.getWidth()-8, img.getHeight()-8);
        img.drawRect(2+3,2+3,img.getWidth()-10, img.getHeight()-10);
         
        //设置积分与生命值显示
        img.setFont(new Font(true, false, 50));
        img.drawString("You are Win!", 150, 280);
        setImage(img);
        img.setTransparency(0);//开始不可见
    }
    
    public void change() {
        this.img.setTransparency(255);
    }

}
