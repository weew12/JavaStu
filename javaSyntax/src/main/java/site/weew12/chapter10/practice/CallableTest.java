package site.weew12.chapter10.practice;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class NumThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

/**
 * 创建多线程的方式三：实现Callable接口
 */
public class CallableTest {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask numThreadFutureTask = new FutureTask(numThread);
        Thread thread = new Thread(numThreadFutureTask);
        thread.start();
        try {
            Object sum = numThreadFutureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
