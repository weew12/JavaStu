import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 3*3 拼图
 */
public class Level1 extends World
{
    private ArrayList<Pic> pics = new ArrayList<Pic>();  //图片对象列表
    private Pic lastPic;  //最后一张图片
    private boolean run;  //游戏状态标识
    private int count; // 移动次数
    private Counter counter = new Counter(); // 计步显示
    private Timer timer = new Timer(false); // 计时
    
    //构造方法，初始化游戏场景
    public Level1()
    {    
        super(5, 5, 96);  //建立3x3的网格，每个网格的尺寸为96x96
        for (int i=0; i<8; i++) {   //建立8个图片对象，并添加至游戏场景中
            Pic pic = new Pic(i, 1);
            pics.add(pic);
            addObject(pic, i%3+1, i/3+1);
        }
        lastPic = new Pic(8, 1);     //创建最后一个图片对象，并加入游戏场景
        addObject(lastPic, 2+1, 2+1);
        run = false;
    }

    //重置图片，打乱图片的显示顺序
    public void resetPics(){
        for (int i=0; i<8; i++) {  //将图片从游戏场景移除
            removeObject(pics.get(i));
            Greenfoot.delay(30);
        }
        removeObject(lastPic);
        Greenfoot.delay(30);
        Collections.shuffle(pics);  //随机打乱图片列表中的图片位置
        for (int i=0; i<8; i++) {   //将打乱后图片重新加入游戏场景
            addObject(pics.get(i), i%3+1, i/3+1);
        }
        run=true;  //将游戏状态标识为运行
        // 计时
        addObject(timer, 1, 4);
        // 返回
        Exit exit = new Exit();
        addObject(exit, 4, 4);
        // 计步
        addObject(counter, 2, 4);
    }
    
    //更新游戏世界的运行逻辑
    public void act() {
        
        if (!run) {  //若游戏尚未运行，则重置图片
            resetPics();
        }
        
        // 步数检测 更新
        counter.setValue(count);
        
        for (int i=0; i<8; i++) {  //判断拼图是否完成
            List<Pic> pictures = getObjectsAt(i%3+1, i/3+1, Pic.class);
            if (pictures.size()==0 || pictures.get(0).getValue()!=i) return;
        }
        addObject(lastPic, 2+1, 2+1);  //加入最后一张图片
        // 结束
        // 数据对比保存
        String cosTime = Integer.toString(timer.getTime());
        try{
            DataRecord.saveData(
                    System.currentTimeMillis(),
                    Integer.parseInt(cosTime),
                    count,
                    1
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
