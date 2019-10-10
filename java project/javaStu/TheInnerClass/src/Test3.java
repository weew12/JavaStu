package Test3;
/**
 * @Classname Test3
 * @Description
 *               局部内部类
 * @Date 2019-10-10
 * @Created by 枫weew12
 */
public class Test3 {

    public static void main(String[] args) {

        Outer outer = new Outer();
        outer.add(100, 300);
    }
}

//外部类
class Outer {

    // 外部类成员变量
    private int value = 10;

    // 外部类方法
    public void add(final int x, int y) {

        //局部变量
        int z = 100;

        // 定义内部类
        class Inner {

            // 内部类方法
            void display() {
                int sum = x + z + value;
                System.out.println("sum = " + sum);
            }
        }

        // Inner inner = new Inner();
        // inner.display();
        //声明匿名对象
        new Inner().display();
    }
}