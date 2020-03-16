import greenfoot.*;  

/**
 * 提供字体样式 字符串 图片大小
 * 生成 字符串的 GreenfootImage
 */
public class StringImage extends Actor
{
    /**
     * 显示字符串
     * */
    private String content; 
    /**
     * 字体大小
     * */
    private int size; 
    /**
     * 图片宽
     * */
    private int width; 
    /**
     * 图片高
     * */
    private int height; 
    /**
     * 颜色
     * */
    private Color color;

    /**
     * 构造函数
     * */
    public StringImage(String content, int size,int width, int height, Color color) {
        this.content = content;
        this.size = size;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * 生成图片
     * */
    public GreenfootImage createImage() {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(color);
        // 加粗 非斜体
        img.setFont(new Font("SansSerif", true, false, size));
        img.drawString(content, 0, size);
        return img;
    }
}
