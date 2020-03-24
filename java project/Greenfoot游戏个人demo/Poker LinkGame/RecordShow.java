import greenfoot.*;

/**
 * 游戏历史记录展示
 * 设置游戏排名后最高的十条记录
 * 分别按耗时与翻牌次数进行排名
 * 耗时权重高于翻牌次数
 * */
public class RecordShow extends World
{
    /**
     * 构造函数初始化
     * */
    public RecordShow()
    {
        super(700, 500, 1);
        // 添加场景边框
        addBorder();
        // 添加返回按钮
        addObject(new Exit(), 650, 450);
        // 显示数据
        showRecords();
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
        img.setColor(Color.BLACK);
        img.setFont(new Font(true, false, 40));
        img.drawString("历史记录", getWidth()/5*2, 60);

        setBackground(img);
    }

    /**
     * 读取展示游戏记录
     * */
    public void showRecords() {
        // 读取结果
        String records = "";
        try {
            // 调用静态方法读取数据文件的数据到字符串
            records = DataRecord.getRecords();
        } catch(Exception e) {
            e.printStackTrace();
        }

        // 将获取的游戏数据字符串绘制到图片上展示出来
        GreenfootImage img = getBackground();
        // 白色字体
        img.setColor(Color.WHITE);
        img.setFont(new Font(true, false, 23));
        img.drawString(records, getWidth()/50,100);
        setBackground(img);
    }
}
