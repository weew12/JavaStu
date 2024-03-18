import greenfoot.*;


/**
 * 游戏菜单
 * */
public class Menu extends Actor
{

    /**
     * 按钮颜色
     * */
    public final Color WHITE = Color.WHITE;
    public final Color BLACK = Color.BLACK;
    /**
     * 按钮文字
     * */
    protected String content; 
    /**
     * 样式图片
     * */
    GreenfootImage img = getImage();
    
    /**
     * 构造函数
     * 获取按钮文字
     * */
    public Menu(String content) {
        this.content = content;
    }
    
    /**
     * 按钮检测点击行为并且切换到相应场景
     * */
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if(mouse == null) {
            return;
        }
        
        if(mouse.getActor() == this) {
            drawMainMenuItem(content, BLACK);
        } else {
            drawMainMenuItem(content, WHITE);
        }
        
    }

    /**
     * 绘制按钮
     * */
    public void drawMainMenuItem(String content, Color color) {
        StringImage exit = new StringImage(content, 40, 175, 45, color);
        img = exit.createImage();
        setImage(img);
    }
}
