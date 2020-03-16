import greenfoot.*; 

/**
 * 扑克牌类型2 蓝色小牌
 * 继承自Card类
 * 改动： 牌面大小58*77
 * */
public class Card2 extends Card
{
    /**
     * 牌面大小做调整
     * */
    public Card2(int cardValue, int choose) {
        super(cardValue, choose);
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
