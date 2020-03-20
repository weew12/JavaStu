import greenfoot.*;

/**
 * 返回按钮
 */
public class Exit extends Menu
{
    /**
     * 构造函数
     * */
    public Exit() {
        super("返回");
    }

    @Override
    public void act()
    {
        //System.out.println("chufa ");
        super.act();
        if(Greenfoot.mouseClicked(this)) {
            String nowWorld = getWorld().getClass().getName();
            //在选择菜单的话返回主界面 在游戏规则界面同
            if("ChooseLevel" == nowWorld || "RulesShow" == nowWorld || "RecordShow" == nowWorld) {
                Greenfoot.setWorld(new StartWindow());
            }
            // 在游戏界面 回到上个界面
            if("Level1" == nowWorld || "Level2" == nowWorld || "Level3" == nowWorld) {
                Greenfoot.setWorld(new ChooseLevel());
            }
        }
    }
}
