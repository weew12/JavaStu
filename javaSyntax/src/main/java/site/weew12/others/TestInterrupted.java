package site.weew12.others;

/**
 * @author weew12
 */
public class TestInterrupted {
    public static void test1() throws Throwable {
        /*
          当线程在sleep()中被interrupt时，会导致抛出InterruptedException
          同时线程的终端状态会被清除！！！
         */
        Thread thread = new Thread(() -> {
            for (; ; ) {
                System.out.println(123);
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("InterruptedDemo is isInterrupted!");
                    break;
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("InterruptedDemo is InterruptedException!");
                }
            }
        });

        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }

    public static void test2() throws Throwable {
        Thread thread = new Thread(() -> {
            for (; ; ) {
                System.out.println(123);
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("InterruptedDemo is isInterrupted!");
                    break;
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("InterruptedDemo is InterruptedException!");
                    /*
                    * 重新设置中断状态，这样下次就不会陷入死循环！
                    * */
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }


    public static void main(String[] args) throws Throwable {
//        test1();
        test2();
    }
}
