import greenfoot.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.lang.Math;

/**
 * 牌桌类
 * 高级模式 - 普通模式
 */
public class Level2 extends World{
    /**
     * 声明一个保存扑克牌对象的集合cards
     * */
    ArrayList<Card2> cards = new ArrayList<Card2>();
    /**
     * 计时器
     * */
    private Timer timer = new Timer(false);
    /**
     * 计数器
     * */
    private Counter counter = new Counter();
    /**
     * 存储历史数据
     * */
    private Map<String,Integer> record = new HashMap<>();

    /**
     * 构造方法
     * */
    public Level2() {
        super(700, 500, 1);
        // 向集合cards中添加9组共18张牌 花色随机 点数随机
        for (int i=1; i<=9; i++) {
            //0-3
            int type = (int)(Math.random()*3);
            // 1-13
            int number = (int)(Math.random()*12)+1;
            cards.add(new Card2(number, type));
            cards.add(new Card2(number, type));
        }

        // 打乱
        for(int i = 0; i < 3; i++) {
            Collections.shuffle(cards);
        }

        // 摆放
        //牌桌上摆放牌的起点坐标
        int x=150, y=175;
        //用for循环依次在牌桌上摆放每排6张，共3排的扑克牌
        for (int i=0; i<18; i++) {
            if(i % 6 == 0 && i != 0) {
                y += 90;
                x = 150;
            }
            addObject(cards.get(i) , x, y);
            x += cards.get(i).getImage().getWidth()+20;
        }

        prepare();
    }

    /**
     * act()方法是游戏单步执行的动作
     * */
    public void act() {
        //count表示牌桌上被翻开的第几张牌
        int count = 0, card1Value=0, card2Value;
        // 牌面花色
        String card1Type="",card2Type;
        Card card1=null, card2;
        //用for循环遍历集合cards中的所有牌
        for (int i=0; i< cards.size(); i++) {
            //如果遍历到的这张牌是翻开的
            if (cards.get(i).getFaceup() == true) {
                //用count将牌桌上翻开的牌数累加
                count++;
                // 记录点击数据备用   对象hash做标识
                record.put(
                        Integer.toString((cards.get(i).hashCode())),
                        cards.get(i).getCount()
                );
                //如果是第一张翻开的牌
                if (count == 1) {
                    card1 = cards.get(i);
                    //变量card1Value记录第一张翻开牌的点数
                    card1Value = card1.getValue();
                    // 获取记录花色
                    card1Type = card1.getType();
                }
                //如果是第二张翻开的牌
                if (count == 2) {
                    card2 = cards.get(i);
                    //变量card2Value记录第二张翻开牌的点数
                    card2Value = card2.getValue();
                    // 获取记录花色
                    card2Type = card2.getType();
                    // 如果翻开的两张牌的点数是一样的花色也是一样的
                    if (card1Value == card2Value && card1Type == card2Type) {
                        Greenfoot.playSound("WaterDrop.wav");
                        //延迟10毫秒，游戏效果更好
                        Greenfoot.delay(10);
                        //移除翻开的两张同样的牌
                        removeObject(card1);
                        removeObject(card2);
                        cards.remove(card1);
                        cards.remove(card2);
                        //配对的牌全部找到，游戏结束
                        if (cards.size() == 0) {
                            String cosTime = Integer.toString(timer.getTime());
                            String totCount = Integer.toString(counter.getValue()+1);
                            GreenfootImage img = new GreenfootImage(
                                    "GameOver\n耗时:"+cosTime+"s  翻牌:"+totCount+"次",
                                    30,
                                    Color.BLACK,
                                    new Color(255,255,255, 100)
                            );
                            GreenfootImage back = getBackground();
                            back.drawImage(img, 251, 220);
                            setBackground(back);
                            timer.stopTimer();
                            // 数据对比保存
                            try{
                                DataRecord.saveData(
                                        System.currentTimeMillis(),
                                        Integer.parseInt(cosTime),
                                        Integer.parseInt(totCount),
                                        2
                                );
                            } catch(Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    //如果翻开的两张牌不同
                    else {
                        Greenfoot.delay(15);
                        // 将两张牌面朝下背朝上
                        card1.turnFaceDown();
                        card2.turnFaceDown();
                    }
                    //两张牌如相同，则移除，如不同，则翻回来。剩下的牌不再遍历，结束for循环
                    break;
                }
            }
        }

        // 更新计数器
        updateCounter();
    }

    /**
     * 获取历史点数并且更新计数器
     * */
    private void updateCounter() {
        // 总翻牌数
        int sum = 0;
        // 累加牌面点击总和
        for(int value:record.values()) {
            sum += value;
        }
        // 更新计数器的值
        counter.setValue(sum);
    }

    /**
     * 为程序启动准备场景
     * 即：创建初始的物体并将其加入场景。
     */
    private void prepare()
    {
        // 加入计时器到场景
        addObject(timer,getWidth()/10*4,getHeight()/12);
        // 加入计数器到场景
        addObject(counter,getWidth()/10*6,getHeight()/12);

        // 设置牌桌背景
        GreenfootImage backImg = getBackground();
        backImg = new GreenfootImage("pokerTable.jpg");
        backImg.scale(getWidth(), getHeight());

        // 文字提示
        backImg.setColor(Color.WHITE);
        backImg.setFont(new Font(true,true,25));
        backImg.drawString(
                " 计时         翻牌次数",
                getWidth()/10*3+15,
                getHeight()/26*5+10
        );
        setBackground(backImg);

        // 返回按钮
        Exit exit = new Exit();
        addObject(exit, getWidth()/20*19, getHeight()/10*9);
    }
}
