package site.weew12.others;

/**
 * 测试尾递归和普通递归的效率差别
 * JVM似乎是不支持尾递归的优化。。。
 * @author weew12
 */
public class TestTailRecur {
    
    public static long traditionalRecursion(int n) {
        /*
            递归求： 1 + 2 + ... + n递归求： 1 + 2 + ... + n
         */
        if (n == 1) {
            return 1;
        }
        long res = traditionalRecursion(n - 1);

        return res + n;
    }
    
    public static long tailRecursion(int n) {
        /*
            递归求： 1 + 2 + ... + n递归求： 1 + 2 + ... + n
         */
        if (n == 1) {
            return 1;
        }
        return n + traditionalRecursion(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("============== 1000 ====================");
        long start1 = System.nanoTime();
        long res1 = traditionalRecursion(1000);
        System.out.println(System.nanoTime() - start1);

        long start2 = System.nanoTime();
        long res2 = tailRecursion(1000);
        System.out.println(System.nanoTime() - start2);

    }
}
