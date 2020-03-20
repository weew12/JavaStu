import greenfoot.*;

/**
 * 游戏规则
 * */
public class GameRules extends Menu
{
    /**
     * 构造函数
     * */
    public GameRules() {
        super("游戏规则");
        drawMainMenuItem(content, Color.RED);
    }

    public void act()
    {
        super.act();
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new RulesShow());
        }
    }

}
