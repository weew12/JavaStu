import greenfoot.*;

/**
 * 扑克牌类，可以被翻开
 * 可以记录自身被点击的次数
 * 注： int 默认为-1 boolean 默认为false 对象引用默认未赋值为null 故此处不做重复赋值
 */
public class Card extends Actor{
    /**
     * 初始点数为-1，表示还没有生成确定的扑克牌。一旦生成了一张牌，其点数就不为-1
     * */
    protected int value;
    /**
     * isFaceUp=true，则牌正面朝上，否则背面朝上
     * */
    protected boolean isFaceUp;
    /**
     * faceUpImage表示牌的正面图案文件
     * */
    protected GreenfootImage faceUpImage;
    /**
     * //faceDownImage表示牌的背面面图案文件
     * */
    protected GreenfootImage faceDownImage;
    /**
     * 花色选择 提供随机生成花色的功能
     * */
    protected String[] types = {"hearts", "clubs", "diamonds", "spades"};
    /**
     * 记录牌面点击次数
     * 翻开牌面点击无效
     * */
    protected int count = 0;
    /**
     * 花色
     * */
    protected String cardType;

    /**
     * Card类的构造方法
     * @param cardValue: 牌面的点数
     * @param choose: 牌面花色
     * */
    public Card(int cardValue, int choose) {
        cardType = types[choose];
        value = cardValue;
        //所有被构造的牌都是背面朝上的
        isFaceUp = false;
        //根据牌点数匹配的正面图案文件名
        String fileName = types[choose] + value + ".png";
        //生成牌的正面图像对象
        faceUpImage = new GreenfootImage(fileName.toLowerCase());
        //生成牌的背面图案对象
        faceDownImage = new GreenfootImage("blueflip.png");
        //让牌背面朝上放在牌桌上
        setImage(faceDownImage);
    }

    /**
     * act()方法是游戏单步执行的动作
     * */
    public void act() {
        // 如果鼠标点击了这张牌
        if (Greenfoot.mouseClicked(this) ){
            // 如果牌面朝下，就翻牌。
            if (!isFaceUp) {
                setImage(faceUpImage);
                isFaceUp = true;
                // 点击一次记数一次 放在此处 防止牌面翻开后反复点击
                count += 1;
            }
        }
    }

    /**
     * 获取这张牌的点数
     * */
    public int getValue(){
        return value;
    }

    /**
     * 获取这张牌的花色
     * */
    public String getType() {
        return cardType;
    }

    /**
     * 获取这张牌是否已翻面
     * */
    public boolean getFaceup(){
        return isFaceUp;
    }

    /**
     * 将牌翻成背部朝上
     * */
    public void turnFaceDown(){
        isFaceUp = false;
        setImage(faceDownImage);
    }

    /**
     * 获取牌被翻开的次数
     * */
    public int getCount() {
        return count;
    }
}