import greenfoot.*;

/**
 * 难度二选择按钮
 */
public class Lev2 extends Menu
{
    /**
     * 构造函数
     * */
    public Lev2() {
        super("普通模式");
    }

    public void act()
    {
        super.act();
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Level2());
        }
    }
}
