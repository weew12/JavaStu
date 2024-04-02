package site.weew12.chapter7.practice;

class Base {
    int count = 10;

    public void display() {
        System.out.println(this.count);
    }

}

class Sub extends Base {
    int count = 20;

    @Override
    public void display() {
        System.out.println(this.count);
    }

}

/**
 * 继承成员变量和继承方法的区别
 *
 * @author weew12
 */
public class FieldMethodTest {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count); // 20
        s.display(); // 20
        Base b = s;
        System.out.println(b == s); // true
        System.out.println(b.count); // 10   分析：成员变量没有多态
        b.display(); // 20

    }

}