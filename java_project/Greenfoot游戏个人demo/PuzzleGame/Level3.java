import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 5*5 拼图 限时 20min
 */
public class Level3 extends World
{
    private ArrayList<Pic> pics = new ArrayList<Pic>();  //图片对象列表
    private Pic lastPic;  //最后一张图片
    private boolean run;  //游戏状态标识
    private int count; // 移动次数
    private Counter counter = new Counter(); // 计步显示
    // 时间
    private Timer timer = new Timer(true);
    /**
     * 游戏结束
     * */
    private boolean gameOver = false;
    //构造方法，初始化游戏场景
    public Level3()
    {    
        super(7, 7, 100);  //建立3x3的网格，每个网格的尺寸为96x96
        for (int i=0; i<24; i++) {   //建立8个图片对象，并添加至游戏场景中
            Pic pic = new Pic(i, 3);
            pics.add(pic);
            addObject(pic, i%5+1, i/5+1);
        }
        lastPic = new Pic(24, 3);     //创建最后一个图片对象，并加入游戏场景
        addObject(lastPic, 4+1, 4+1);
        run = false;

    }

    //重置图片，打乱图片的显示顺序
    public void resetPics(){
        for (int i=0; i<24; i++) {  //将图片从游戏场景移除
            removeObject(pics.get(i));
            Greenfoot.delay(90);
        }
        removeObject(lastPic);
        Greenfoot.delay(90);
        Collections.shuffle(pics);  //随机打乱图片列表中的图片位置
        for (int i=0; i<24; i++) {   //将打乱后图片重新加入游戏场景
            addObject(pics.get(i), i%5+1, i/5+1);
        }
        run=true;  //将游戏状态标识为运行

        addObject(timer, 1, 6);
        // 返回
        Exit exit = new Exit();
        addObject(exit, 6, 6);
        // 计步
        addObject(counter, 3, 6);
    }
    
    //更新游戏世界的运行逻辑
    public void act() {
        if (!run) {  //若游戏尚未运行，则重置图片
            resetPics();
        }

        // 步数检测 更新
        counter.setValue(count);
        
        // 判断是否超时 gameover 标志用于判断 防止重复执行
        if( timer.getTime() == 0 && !gameOver) {
            gameOver = true;
            removeObjects(pics);
            GreenfootImage img = new GreenfootImage(
                    "抱歉，您已经超时！挑战失败",
                    40, Color.BLACK,
                    new Color(255,255,255, 100)
            );
            GreenfootImage back = getBackground();
            back.drawImage(img, 140, 220);
            setBackground(back);
            // 停止计时
            timer.stopTimer();
            Greenfoot.stop();   
        }
        
        for (int i=0; i<24; i++) {  //判断拼图是否完成
            List<Pic> pictures = getObjectsAt(i%5+1, i/5+1, Pic.class);
            if (pictures.size()==0 || pictures.get(0).getValue()!=i) return;
        }
        addObject(lastPic, 4+1, 4+1);  //加入最后一张图片
        // 结束
        // 数据对比保存
        String cosTime = Integer.toString(timer.getTime());
        try{
            DataRecord.saveData(
                    System.currentTimeMillis(),
                    Integer.parseInt(cosTime),
                    count,
                    3
            );
        } catch(Exception e) {
            e.printStackTrace();
        }
        Greenfoot.playSound("win.wav"); //播放完成的音效
        timer.stopTimer();
        Greenfoot.stop();          //停止游戏
    }
    
        // 更新步数
    public void updateCount() {
        count ++;
    }
}
