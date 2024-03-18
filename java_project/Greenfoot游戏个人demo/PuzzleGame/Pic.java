import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * 图片类，用来表示组成完整拼图的每个图片
 */
public class Pic extends Actor{
    
    private int value; //图片的索引值
    private int level; //游戏模式 1--3*3 2--4*4 3--5*5
    
    //构造方法，设置图片索引值和相关图像
    public Pic(int value, int level) {
        this.value = value;
        this.level = level;

        switch(level) {
            case 1:
                setImage("level1/" + value+".jpg");
                break;
            case 2:
                setImage("level2/" + value+".jpg");
                break;
            case 3:
                setImage("level3/" + value+".jpg");
                break;
        }
    }
    
    //获取图片索引值
    public int getValue() {
        return value;    
    }
    
    //更新图片对象的运行逻辑
    public void act() {   
        //boolean move = false;

        if (Greenfoot.mouseClicked(this)) {  //若鼠标点击图片，则检查其四围是否可以移动
            //检查上方是否可移动
            if (getY()>1 && checkPic(getX(), getY()-1)) {  
                setLocation(getX(), getY()-1);
                //move = true;
                update();
                return;
            }       
            //检查下方是否可移动
            if (getY()<(level+2) && checkPic(getX(), getY()+1)) {  
                setLocation(getX(), getY()+1);
                //move = true;
                update();
                return;
            }       
            //检查左方是否可移动
            if (getX()>1 && checkPic(getX()-1, getY())) {  
                setLocation(getX()-1, getY());
                //move = true;
                update();
                return;
            }
            //检查右方是否可移动
            if (getX()<(level+2) && checkPic(getX()+1, getY())) { 
                setLocation(getX()+1, getY());
                //move = true;
                update();
                return;
            } 
        }
    }    
    
    public void update() {
        // 当前类
        String nowWorld = getWorld().getClass().getName();

        // 计数加一
        if (nowWorld == "Level1") {
            Level1 now = (Level1)getWorld();
            now.updateCount();
        } else if (nowWorld == "Level2") {
            Level2 now = (Level2)getWorld();
            now.updateCount();
        } else {
            Level3 now = (Level3)getWorld();
            now.updateCount();
        }
    }
    
    //检查某个方格是否有图片
    private boolean checkPic(int x, int y) {
        List<Pic> pics = getWorld().getObjectsAt(x, y, Pic.class);
        if (pics.size()>0) {
            return false;
        } else {
            return true;
        }
    }
}
