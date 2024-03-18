import greenfoot.*;

/**
 * 难度选择界面
 * 难度一 普通模式
 * 难度二 中级模式
 * 难度三 困难模式
 */
public class ChooseLevel extends World
{
    public ChooseLevel()
    {
        super(700, 500, 1);
        initChooseLevel();
    }

    /**
     * StartWindow 初始化场景
     */
    public void initChooseLevel() {
        initScenario();
        setBackGroundImage();// 背景
    }

    /**
     * 初始化当前world场景
     * */
    private void initScenario() {
        // lv1: 难度一按钮
        Lev1 lv1 = new Lev1();
        addObject(lv1, getWidth()/2, getHeight()/6*2);
        // lv2: 难度二按钮
        Lev2 lv2 = new Lev2();
        addObject(lv2, getWidth()/2, getHeight()/6*3);
        // lv3: 难度三按钮
        Lev3 lv3 = new Lev3();
        addObject(lv3, getWidth()/2, getHeight()/6*4);
        // 返回按钮
        Exit exit = new Exit();
        addObject(exit, getWidth()/7*6, getHeight()/6*5);
    }
    
    /**
     * itemBox绘制
     */
    private void setBackGroundImage() {
        GreenfootImage img = new GreenfootImage("chooseBackground.jpg");
        // 图片拉伸至场景同等大小
        img.scale(this.getWidth(), this.getHeight());
        // 边框
        img.setColor(new Color(139,139,122));
        // itemBox 绘制
        GreenfootImage itemBox = new GreenfootImage(img.getWidth(), img.getHeight());
        // 边框
        itemBox.setColor(new Color(125,125,125));
        itemBox.setTransparency(150);
        itemBox.fill();
        // 绘制基坐标 x
        int posX = (getWidth() - itemBox.getWidth())/2;
        // 绘制基坐标 y
        int posY = (getHeight() - itemBox.getHeight())/2;
        // 将ItemBox 绘制到整体背景中
        img.drawImage(itemBox, posX, posY);
        setBackground(img);
    }
}
