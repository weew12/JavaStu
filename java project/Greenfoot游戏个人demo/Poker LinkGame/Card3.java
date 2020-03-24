import greenfoot.*;  

/**
 * 扑克牌类型3 红色小牌
 * 继承自Card类
 * 改动： 牌面大小58*77 牌面颜色
 * */
public class Card3 extends Card
{
    /**
     * 牌面大小做调整 牌面颜色做调整
     * */
    public Card3(int cardValue, int choose) {
        super(cardValue, choose);
        faceDownImage = new GreenfootImage("redflip.png");
        this.faceUpImage.scale(58,77);
        this.faceDownImage.scale(58,77);
        setImage(faceDownImage);
    }
    
    /**
     * act() 继承Card默认行为
     * */
    public void act()
    {
        super.act();
    }
}
