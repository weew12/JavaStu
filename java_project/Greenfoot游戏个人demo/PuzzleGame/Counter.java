import greenfoot.*; 

/**
 * 翻牌计数器
 * */
public class Counter extends Actor
{
    /**
     * 背景图片
     * */
    private GreenfootImage background;
    /**
     * 翻牌次数
     * */
    private int value;

    /**
     * 构造函数
     * */
    public Counter()
    {
        background = getImage();
        // 初始值 0
        value = 0;
        updateCounter();
    }
    
    /**
     * 检测数值变化并且更新
     * */
    public void act()
    {
        updateCounter();
    }

    /**
     * 设置value 记数
     * */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 更新显示
     */
    private void updateCounter()
    {
        // 图片
        //GreenfootImage image = new GreenfootImage(background);
        // 数字
        GreenfootImage text = new GreenfootImage(
                "步数:" + value,
                35, Color.RED,
                new Color(0,0,0,0)
        ); // 文字大小 字体色 背景色
        
        /*// 部件最底部容器 放图片 和 数字
        GreenfootImage bottom = new GreenfootImage(
                image.getWidth() + 50,
                image.getHeight()
        ); // 考虑时间过长字符串会溢出 将框子设置宽一点
        
        // 底部背景色 透明rgba
        bottom.setColor(new Color(0,0,0,0)); 
        bottom.fill();

        // 将图标与数字嵌入底部容器
        bottom.drawImage(
                text,
                image.getWidth(),
                bottom.getHeight()/4
        );
        bottom.drawImage(
                image,
                0,
                (bottom.getHeight()-image.getHeight())/2
        );*/
        //setImage(bottom);
        setImage(text);
    }

    /**
     * 获取计数
     * */
    public int getValue() {
        return value;
    }
}
