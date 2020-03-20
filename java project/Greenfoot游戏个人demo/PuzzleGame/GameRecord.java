import greenfoot.*;

/**
 * 历史记录
 */
public class GameRecord extends Menu
{
    /**
     * 构造函数
     * */
    public GameRecord() {
        super("历史记录");
        drawMainMenuItem(content, WHITE);
    }
    public void act()
    {
        super.act();
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new RecordShow());
        }
    }
}
