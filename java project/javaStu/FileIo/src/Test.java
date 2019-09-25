/**
 * @Classname Test
 * @Description
 * @Date 2019-08-01-15:04
 * @Created by 枫weew12
 */
public class Test {
    public static void main(String[] args) {
        long time1 = System.nanoTime();
        System.out.println("test");
        System.out.println("测试");
        long time2 = System.nanoTime();
        System.out.println("running cost: " + (time2 - time1));
    }

}

