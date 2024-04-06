package site.weew12.chapter11;

import java.util.Arrays;

/**
 * java.lang.System相关使用
 *
 * @author weew12
 */
public class SystemTest {
    public static void test1() {
        long l = System.currentTimeMillis();
        System.out.println(l);
        System.exit(0);
//        // 不会执行
//        System.out.println("over");
    }

    public static void test2() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("Java Version: " + javaVersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("Java Home: " + javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("OS Name: " + osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("OS Version: " + osVersion);

        String userHome = System.getProperty("user.home");
        System.out.println("User Home: " + userHome);

        String userDir = System.getProperty("user.dir");
        System.out.println("User Dir: " + userDir);
    }

    public static void test3() {
        for (int i = 0; i < 10; i++) {
            DemoClass demoClass = new DemoClass(i);
        }
        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test4() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[10];

        System.arraycopy(arr1, 0, arr2, 3, arr1.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        System.out.println("===================");

        System.arraycopy(arr1, 0, arr1, 1, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }
}

class DemoClass {
    private int value;

    public DemoClass(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DemoClass{" +
                "value=" + value +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this + "finalize method has been invoked...");
    }
}