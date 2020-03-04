import greenfoot.*;

public class SettingScreen extends Actor
{
    // 显示大小 宽度高度设置
    public static Color BACKGROUND = new Color(198, 214, 224, 236);// 背景色 rgba
    public static Color FOREGROUND = new Color(48, 88, 126); // 前景色 rgb

    // 创建返回一个GreenfootImage
    public GreenfootImage getAnGreenfootImage(int width, int height) {
        return new GreenfootImage(width, height);
    }
    
    // 显示图片 GameOver 或 GameWin
    public void change() {}

    // 绘制图片 GameOver 或 GameWin
    public void draw() {}
    
    public void act() {}
}
