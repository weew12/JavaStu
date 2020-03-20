import greenfoot.*;

/**
 * 游戏规则展示界面
 * 读取游戏规则的数据文件
 * 将游戏规则展示出来
 * */
public class RulesShow extends World
{
    /**
     * 构造函数
     * */
    public RulesShow()
    {
        super(700, 500, 1);
        // 添加边框
        addBorder();
        // 添加返回按钮
        addObject(new Exit(), 650, 445);
        // 读取显示游戏规则
        showRules();
    }

    /**
     * 添加边框
     * */
    public void addBorder() {
        GreenfootImage img = new GreenfootImage("chooseBackground.jpg");
        // 图片拉伸至场景同等大小
        img.scale(this.getWidth(), this.getHeight());
        // 边框
        img.setColor(new Color(139,139,122));
        // itemBox 绘制
        GreenfootImage itemBox = new GreenfootImage(img.getWidth(), img.getHeight());
        // 边框
        itemBox.setColor(new Color(125,125,125));
        itemBox.setTransparency(210);
        itemBox.fill();
        // 绘制基坐标 x
        int posX = (getWidth() - itemBox.getWidth())/2;
        // 绘制基坐标 y
        int posY = (getHeight() - itemBox.getHeight())/2;
        // 将ItemBox 绘制到整体背景中
        img.drawImage(itemBox, posX, posY);
        setBackground(img);
    }

    /**
     * 调用静态方法读取数据文件中保存的游戏数据
     * */
    public void showRules() {
        // 读取结果
        String rules = "";
        try {
            rules = DataRecord.getRules();
        } catch(Exception e) {
            e.printStackTrace();
        }

        GreenfootImage img = getBackground();
        // 字体白色
        img.setColor(Color.WHITE);
        img.setFont(new Font(true, false, 25));
        img.drawString(rules, 12,50);
        setBackground(img);
    }
}
