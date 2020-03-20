import greenfoot.*;

/**
 * 难度一选择按钮
 */
public class Lev1 extends Menu
{
    /**
     * 构造函数
     * */
    public Lev1() {
        super("简单模式");
    }

    public void act()
    {
        super.act();
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Level1());
        }
    }
}
