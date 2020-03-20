import greenfoot.*;

/**
 * 难度三选择按钮
 */
public class Lev3 extends Menu
{
    /**
     * 构造函数
     * */
    public Lev3() {
        super("困难模式");
    }

    public void act()
    {
        super.act();
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Level3());
        }
    }
}
