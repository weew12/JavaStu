import greenfoot.*;

/**
 * 游戏标题
 */
public class GameTitle extends Menu
{
    /**
     * 构造函数
     * */
    public GameTitle() {
        super("POKER LINKGAME");
        draw(Color.RED);
    }
    
    @Override
    public void act()
    {
        draw(Color.RED);
    }

    // 绘制按钮标签
    public void draw(Color color) {
        StringImage exit = new StringImage("POKER LINKGAME", 52, 480, 57, color);
        img = exit.createImage();
        setImage(img);
    }
}
