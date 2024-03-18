import greenfoot.*;

/**
 * 游戏历史记录展示
 * 设置游戏排名后最高的六条记录
 * 分别按耗时与移动次数进行排名
 * 耗时权重高于移动次数
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
        addObject(new Exit(), 650, 455);
        // 显示数据
        showRecords();
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
        img.drawString(records, getWidth()/20,50);
        setBackground(img);
    }
}
