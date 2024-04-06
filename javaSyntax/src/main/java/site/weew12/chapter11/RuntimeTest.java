package site.weew12.chapter11;

/**
 * Java的Runtime类测试
 *
 * @author weew12
 */
public class RuntimeTest {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        // 获取虚拟机初始化时的堆内存
        long initialMemory = runtime.totalMemory();
        // 获取虚拟机最大堆内存
        long maxMemory = runtime.maxMemory();
        // 模拟内存占用
        String str = "";
        for (int i = 0; i < 10000; i++) {
            str += i;
        }
        long freeMemory = runtime.freeMemory();
        System.out.println("初始总内存： " + initialMemory / 1024 / 1024 * 64 + "MB");
        System.out.println("最大总内存： " + maxMemory / 1024 / 1024 * 4 + "MB");
        System.out.println("空闲内存： " + freeMemory / 1024 / 1024 + "MB");
        System.out.println("已用内存： " + (initialMemory - freeMemory) / 1024 / 1024 + "MB");
    }
}
