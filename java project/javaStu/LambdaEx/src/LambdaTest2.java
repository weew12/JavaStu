/**
 * @Classname LambdaTest2
 * @Description
 * @Date 2019-12-02
 * @Created by 枫weew12
 */
/*线程初始化 验证lambda*/
public class LambdaTest2 {

    public static void main(String[] args) {
        /*old way*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("old Runnable Test");
            }
        }).start();

        /*new lambda*/
        new Thread(() -> System.out.println("new Runnable Test lambda")).start();

    }
}
