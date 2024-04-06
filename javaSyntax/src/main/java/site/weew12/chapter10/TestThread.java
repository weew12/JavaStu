package site.weew12.chapter10;

/**
 * 3.5守护线程测试
 * setDaemon(bool flag)
 * isDaemon()
 */
public class TestThread {
    public static void main(String[] args) {
        MyDaemon m = new MyDaemon();
        // 如果不设置这个为守护线程，则这个线程一直不会结束执行
        m.setDaemon(true);
        m.start();

        for (int i = 1; i <= 100; i++) {
            System.out.println("main:" + i);
        }
    }
}

class MyDaemon extends Thread {
    public void run() {
        while (true) {
            System.out.println("我一直守护者你...");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
