package site.weew12.others;

/**
 * wait 和 notify
 * @author weew12
 * @description
 * 运行结果：
 * 1710811312263:T1 start!
 * 1710811312270:T1 wait for object!
 * 1710811312270:T2 start! notify one thread!
 * 1710811312270:T2 notify end!
 * 1710811314274:T2 sleep 2000ms end!
 * 1710811314274:T1 end!
 *
 * 分析，T2执行notify()之后还没有把拿到的obj监视器释放，并且进入了休眠状态2000ms
 * 因此T1虽然被notify了但是没有拿到obj监视器，因此继续等待知道T2主动释放obj监视器
 */
public class WaitNotifyDemo {
    final static Object OBJ = new Object();

    public static void main(String[] args) {
        new T1().start();
        new T2().start();
    }

    public static class T1 extends Thread {
        /*
            thread wait
         */
        @Override
        public void run() {
            synchronized (OBJ) {
                System.out.println(System.currentTimeMillis() + ":T1 start!");
                try {
                    System.out.println(System.currentTimeMillis() + ":T1 wait for object!");
                    OBJ.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end!");
            }
        }
    }

    public static class T2 extends Thread {
        /*
            notify thread
         */
        @Override
        public void run() {
            synchronized (OBJ) {
                System.out.println(System.currentTimeMillis() + ":T2 start! notify one thread!");
                OBJ.notify();
                System.out.println(System.currentTimeMillis() + ":T2 notify end!");
                try {
                    Thread.sleep(2000);
                    System.out.println(System.currentTimeMillis() + ":T2 sleep 2000ms end!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
