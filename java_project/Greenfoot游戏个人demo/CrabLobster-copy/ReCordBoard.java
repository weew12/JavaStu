import greenfoot.*;
import greenfoot.Font;

/**
 * 展示游戏的数据
 * 每当螃蟹吃掉一只沙虫 螃蟹得1分
 * 每当龙虾吃掉一只螃蟹 螃蟹生命值 减1
 * */
public class ReCordBoard extends SettingScreen
{
    // 绘制记录区域img
    public GreenfootImage img = super.getAnGreenfootImage(200, 40);

    public void act() {}

    public void draw(int score, int life) {
        // 填充
        img.setColor(super.BACKGROUND);
        img.fill();
        img.setColor(super.FOREGROUND);

        // 画边框
        img.drawRect(0+3,0+3,img.getWidth()-6, img.getHeight()-6);
        img.drawRect(1+3,1+3,img.getWidth()-8, img.getHeight()-8);
        img.drawRect(2+3,2+3,img.getWidth()-10, img.getHeight()-10);

        //设置积分与生命值显示
        img.setFont(new Font(true, false, 20));
        img.drawString("积分:" + score, 10, 28);
        img.drawString("生命值:" + life, 100, 28);
        setImage(img);
    }
}
