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
        GreenfootImage img = getBackground();
        // 边框
        img.setColor(new Color(139,139,122));

        //单个画框太冗杂 此处使用参数设置循环次数来填充绘制边框效果
        int fill = 18;
        for(int i =1; i<= fill; i++) {
            img.drawRect(i/2, i/2, img.getWidth()-i, img.getHeight()-i);
        }
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
