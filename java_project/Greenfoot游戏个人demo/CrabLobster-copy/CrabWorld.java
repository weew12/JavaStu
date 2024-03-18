import greenfoot.*;
import java.util.Random;


public class CrabWorld extends World
{
    public int score = 0; // 分数
    public int life = 5;  // 生命

    public ReCordBoard setBoard = new ReCordBoard(); // 数据记录
    public GameOver showGameOver = new GameOver(); // 游戏结束界面 over
    public GameWin showGameWin = new GameWin(); // 游戏结束界面 win
    public Crab crab = new Crab(); // 螃蟹(游戏者)

    public CrabWorld()
    {
        super(600, 600, 1);
        this.startGame();
    }

    // 初始化游戏
    public void startGame() {
        this.initAnimals();
        this.initHint();
        this.initData();
    }
    
    // 初始化动物
    public void initAnimals() {
        // 螃蟹 1
        int posX1 = getRandom(14)*40+40;
        int posY1 = getRandom(14)*40+40;
        this.addObject(crab, posX1, posY1);

        // 沙虫 10
        int count2 = 0;
        int posX2 = 0,posY2 = 0;
        while(count2 < 10){
            posX2 = getRandom(14)*40+40;
            posY2 = getRandom(14)*40+40;
            Worm worm = new Worm();
            if (posX1<= posX2 + 4 && posX2 > 20&& posY1 <= posY2 + 4&& posY2 <= 590
                    && posX2 < 590 && posY2 > 50)
            { continue; } else {
                count2 ++;
                this.addObject(worm, posX2, posY2);
            }
        }

        // 龙虾 2
        int count3 = 0;
        int posX3 = 0,posY3 = 0;
        while (count3 < 2) {
            posX3 = getRandom(14)*40+40;
            posY3 = getRandom(14)*40+40;
            Lobster lobster = new Lobster();
            if (posX1<= posX3 + 4 && posX3 > 20&& posY1 <= posY3 + 4&& posY3 <= 590
                    && posX3 < 590 && posY3 > 50)
            { continue; } else {
                count3 ++;
                this.addObject(lobster, posX3, posY3);
            }
        }
    }
    
    // 初始化展示数据 GameOver GameWin ReCordBoard
    public void initHint() {

        setBoard.draw(0,5);// 分数 生命值
        this.addObject(setBoard, 100, 20);

        this.showGameOver.draw();// 游戏结束 (初始化为不可见 当游戏lose 界面出现)
        this.addObject(this.showGameOver, 300, 300);

        this.showGameWin.draw();// 游戏获胜 (初始化为不可见 当游戏wining 界面出现)
        this.addObject(this.showGameWin, 300, 300);
    }
    
    // 数据初始化
    public void initData() {
        this.life = 5;
        this.score = 0;
    }
    
    // 创建螃蟹
    public void resetCrabPosition() {
        this.crab.setLocation(getRandom(14)+40, getRandom(14)+40);
    }
    
    // 移除螃蟹
    public void removeCrab() { this.removeObject(this.crab); }
    
    // 重绘数据板
    public void refreshBoard(int score, int life) { setBoard.draw(score, life); }
    
    // 设置游戏结束 lose
    public void setGameOver() { this.showGameOver.change(); /* 显示GameOver界面*/ }
    
    // 设置游戏胜利 win
    public void setGameWin() { this.showGameWin.change(); /* 显示GameWin界面*/ }
    
    // 设置score
    public void setScore(int score) { this.score = this.score + score;}
    
    // 设置life
    public void setLife(int life) { this.life = this.life - life;}
    
    // 获取指定范围内的随机数
    public int getRandom(int area) { return Greenfoot.getRandomNumber(area); }
}
