import greenfoot.*;

/**
 * startWindow
 * 游戏主界面
 * 游戏启动 当前场景为startWorld
 */
public class StartWindow extends World
{
    /**
     * 构造函数
     * */
    public StartWindow()
    {
        super(700, 500, 1);
        // startWindow 全部初始化
        initScenario();
    }

    /**
     * StartWindow 初始化场景
     * */
    public void initStartWindow() {
        initScenario();
    }

    /**
     * 创建当前world场景
     * */
    private void initScenario() {
        setBackGroundImage();
        addItem();
    }

    /**
     * 绘制并设置背景图像
     * */
    private void setBackGroundImage() {
        GreenfootImage img = new GreenfootImage("startBackground.jpg");
        // 图片拉伸至场景同等大小
        img.scale(this.getWidth(), this.getHeight());
        // 边框
        img.setColor(new Color(139,139,122));
        // itemBox 绘制
        GreenfootImage itemBox = new GreenfootImage(img.getWidth()/2, img.getHeight()/2);
        // 边框
        itemBox.setColor(new Color(125,125,125));
        itemBox.setTransparency(150);
        itemBox.fill();
        // 边框
        //单个画框太冗杂 此处使用参数设置循环次数来填充绘制边框效果
        int fill = 18;
        itemBox.setColor(new Color(255,255,255));
        for(int i =1; i<= fill; i++) {
            itemBox.drawRect(i/2, i/2, itemBox.getWidth()-i, itemBox.getHeight()-i);
        }
        // 绘制基坐标 x
        int posX = (getWidth() - itemBox.getWidth())/2;
        // 绘制基坐标 y
        int posY = (getHeight() - itemBox.getHeight())/3*2;
        // 将ItemBox 绘制到整体背景中
        img.drawImage(itemBox, posX, posY);
        setBackground(img);
    }

    /**
     * 添加菜单项 在ItemBox区域
     * */
    private void addItem() {
        // 进入游戏选项
        StartGame startgame = new StartGame();
        addObject(startgame, 360, getHeight()/9*4);

        // 游戏规则选项
        GameRules gamerules = new GameRules();
        addObject(gamerules, 360, getHeight()/9*5);

        // 历史记录选项
        GameRecord gamerecord = new GameRecord();
        addObject(gamerecord, 360, getHeight()/9*6);
    }
}
