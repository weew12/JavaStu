import greenfoot.*;  

public class Worm extends Animals
{
    public void act() {
       /* this.move(1);
        this.turnAtEdge();
        if(this.getRandomNumber(100) < 10) {
            this.turn(2);
        }
        */
       
       // 躲避螃蟹 此处只设置左右方向的躲避
        int res = isNearCrab();
        if(res == 1) {
            this.move(-3);
        } else if(res == 2) {
            this.move(3 );
        }
    }
    
    // 是否有螃蟹靠近 
    
    public int isNearCrab() {

        int direction = 0;
        
        java.util.List<Crab> res = this.getNeighbours(100, false, Crab.class);
        if(!res.isEmpty()) {
            int nowPos = this.getX();
            int CrabPosX = this.getWorld().crab.getX();
            if(nowPos > CrabPosX) {
                direction = 2;
            } else {
                direction = 1;
            }
        }
        return direction;
    }
}
