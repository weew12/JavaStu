package site.weew12.chapter7;

/**
 * static 用法测试
 * @author weew12
 */
public class StaticTest {
    public static void main(String[] args) {
        Demo demo = null;
        demo.hello(); // 可以通过编译
//        demo.nonHello(); // 不可以通过编译 会抛出空指针异常

    }
}

class Demo {
    public static void hello() {
        System.out.println("static method print hello");
    }

    public void nonHello(){
        System.out.println("no static method print hello");
    }
}
