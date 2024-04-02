package site.weew12.chapter8;

/**
 * 测试：包装类对象不可变
 * 包装类对象是“不可变”对象，一旦修改，就是新对象，就和实参无关了
 */
public class TestExam {
    public static void main(String[] args) {
        int i = 1;
        Integer j = new Integer(2);
        System.out.println("j hashcode:" + j.hashCode());
        Circle c = new Circle();
        System.out.println("c hashcode:" + c.hashCode());
        change(i, j, c);
        System.out.println("after change invoked -> j hashcode:" + j.hashCode());
        System.out.println("after change invoked -> c hashcode:" + c.hashCode());
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("c.radius = " + c.radius);
    }

    public static void change(int i, Integer j, Circle c) {
        i += 10;
        System.out.println("Inner Method -> j hashcode:" + j.hashCode());
        j += 10;
        // j = new Integer(10 + j) 返回的是新的对象不是原来的那个
        System.out.println("Inner Method -> after +10 ： j hashcode:" + j.hashCode());
        System.out.println("Inner Method -> c hashcode:" + c.hashCode());
        c.radius += 10;
        System.out.println("Inner Method -> after +10 ：c hashcode:" + c.hashCode());
    }
}

class Circle {
    double radius;
}
