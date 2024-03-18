/**
 * @Classname Test
 * @Description
 *                  示例内部类
 * @Date 2019-10-10
 * @Created by 枫weew12
 */
public class Test {

    public static void main(String[] args) {

        // 通过外部类访问内部类
        Outer outer = new Outer();
        outer.test();

        // 直接访问内部类
        System.out.println("--------直接访问内部类---------");
        Outer.Inner inner = outer.new Inner();
        inner.display();
    }
}

class Outer {

    // 外部类成员变量
    private int x = 10;
    //外部类方法
    private void print() {
        System.out.println("调用外部方法...");
    }
    //测试调用内部类
    public void test() {
        Inner inner = new Inner();
        inner.display();
    }

    // 内部类
    class Inner {

        // 内部类成员变量
        private int x = 5;
        // 内部类方法
        void display() {
            // 访问外部类的成员变量x
            System.out.println("外部成员变量 x = " + Outer.this.x);
            // 访问内部类的成员变量x
            System.out.println("内部成员变量 x = " + this.x);
            System.out.println("内部成员变量 x = " + x);

            // 调用外部类方法
            Outer.this.print();
            print();
        }
    }
}