import greenfoot.*;

/**
 * 进入游戏
 */
public class StartGame extends Menu
{
    /**
     * 构造函数
     * */
    public StartGame() {
        super("进入游戏");
        drawMainMenuItem(content, Color.RED);
    }

    public void act()
    {
        super.act();
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new ChooseLevel());
        }
    }
}
