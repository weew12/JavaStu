package site.weew12.chapter8.practice;

/**
 * 练习11.8 一、二
 */
public class Test11_8_1 {
    public static void main(String[] args) {
        // Test1
        method1();
        System.out.println("**************");
        // Test2
        method2();
    }

    // 测试 1
    // weew12参考gpt3.5
    // 由于条件表达式要求两个分支的类型相同（或可以隐式转换），
    // 所以在这里会发生自动类型转换，
    // 将整数类型的对象转换为浮点数类型的对象

    public static void method1() {
        Object o1 = true ? new Integer(1) : new Double(2.0);
        // 1.0
        System.out.println(o1);

        Object o2;
        if (true) {
            // 1
            o2 = new Integer(1);
        } else {
            o2 = new Double(2.0);
        }
        System.out.println(o2);
    }

    // 测试 2
    public static void method2() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        // false 堆内存对象
        System.out.println(i == j);

        Integer m = 1;
        Integer n = 1;
        //true 包装类缓存对象
        System.out.println(m == n);

        Integer x = 128;
        Integer y = 128;
        //false 不在缓存范围内 -128 ~ 127
        System.out.println(x == y);
    }
}
