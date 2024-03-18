import greenfoot.*;

/**
 * 计数器
 * 1 - 顺序计时 记录时长
 * 2 - 倒计时
 * 使用 ：
 *      Timer(false) 为普通计时
 *      Timer(true) 为倒计时
 * */
public class Timer extends Actor
{
    /**
     * 背景
     * */
    private GreenfootImage background;
    /**
     * 计时数值
     * */
    private int value;
    /**
     * 上一秒开始 时间戳13位 毫秒
     * */
    public static Long start = System.currentTimeMillis();
    /**
     * 最后一次比较的时间 时间戳13位 毫秒
     * */
    public static Long last = 0L;
    /**
     * 倒计时功能开启标志
     * */
    private boolean flag; 
    /**
     * 默认启动,true停止计时
     * */
    private boolean stop = false;
    
    /**
     * 构造函数
     * */
    public Timer(boolean flag)
    {
        this.flag = flag;
        background = getImage();
        // 判断计时模式
        if(!flag) {
            // 普通模式
            value = 0; 
        } else {
            // 倒计时模式
            value = 1200; 
        }
        updateClock();
    }

    /**
     * 获取时间戳与上一次进行比较
     * 通过对比时差获取每一秒间隔实现读秒操作
     * */
    public void act()
    {   
        // 停止计时
        if (stop) { return; }
        // 计时中
        Timer.last = System.currentTimeMillis();

        // 差值1s
        if((Timer.last/1000 - Timer.start/1000) == 1) {
            Timer.start = last;
            // 倒计时模式
            if(flag) { 
                // 倒计时耗尽 重头计时
                if(value <= 0) {
                    value = 1200;
                } else {
                    value -= 1;
                }
            } 
            // 普通计时 
            else {
                value += 1;
            }
            updateClock();
        }
        // **** 此处可有可无 由于人为调试可以暂停 导致时差大于1s 程序逻辑将出现错误(暂停后继续执行导致不再计时)
        // **** 故此处判断大于 1s说明按下过暂停 重新获取时间戳
        else if((Timer.last/1000 - Timer.start/1000) > 1) {
            /*
             * 此处设置判断时间差是否大于1 表示当人为干预暂停时更新start 防止秒表停止计时
             * 但是最好不要暂停 暂停会出现1-2秒的不稳定
             */
            Timer.start = last;
            // 倒计时模式
            if(flag) { 
                if(value <= 0) {
                    value = 1200;
                } else {
                    value -= 1;
                }
            } else {
                value += 1;
            }
            updateClock();
        }
    }
    
    /**
     * 更新计时器显示
     */
    private void updateClock()
    {
        // 时钟图片
        GreenfootImage image = new GreenfootImage(background);
        // 数字
        GreenfootImage text = new GreenfootImage(
                ":" + value,
                35, Color.RED,
                new Color(0,0,0,0)
        ); // 文字大小 字体色 背景色
        
        // 部件最底部容器 放时钟 和 数字
        GreenfootImage bottom = new GreenfootImage(
                image.getWidth() + 50 + 20,
                image.getHeight()
        ); // 考虑时间过长字符串会溢出 将框子设置宽一点

        // 底部背景色 透明rgba
        bottom.setColor(new Color(0,0,0,0)); 
        bottom.fill();

        // 将时钟与数字嵌入底部容器
        bottom.drawImage(text, image.getWidth(), bottom.getHeight()/4);
        bottom.drawImage(image, 0, (bottom.getHeight()-image.getHeight())/2);
        setImage(bottom);
    }

    /**
     * 返回时间数据
     * */
    public int getTime() {
        return value;
    }

    /**
     * 倒计时使用 重置倒计时
     * */
    public void resetValue() {
        value = 1200;
    }

    /**
     * 计时停止
     * */
    public void stopTimer() {
        stop = true;
    }
}
