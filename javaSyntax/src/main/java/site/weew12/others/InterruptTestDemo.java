package site.weew12.others;

import java.util.concurrent.TimeUnit;

/**
 * @author weew12
 * 中断interrupt 、isInterrupted、interrupted 三个函数的测试
 */
public class InterruptTestDemo {

    public static void main(String[] args) {
        // 判断当前线程是否被中断
        System.out.println("Main thread is interrupted? " + Thread.interrupted());
        // 中断当前线程
        Thread.currentThread().interrupt();
        // 判断当前线程是否已经被中断
        System.out.println("Main thread is interrupted? " + Thread.currentThread().isInterrupted());

        try {
            // 当前线程执行可中断方法 sleep
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            // 捕获中断信号
            System.out.println("I will be interrupted still...");
        }
    }
}
