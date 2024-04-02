package site.weew12.chapter7;

class Base {
    int a = 1;
}

class Sub extends Base {
    int a = 2;
}

/**
 * 成员变量没有多态性
 *
 * @author weew12
 */
public class TestVariable {
    public static void main(String[] args) {
        Base b = new Sub();
        System.out.println(b.a);
        System.out.println(((Sub) b).a);

        Sub s = new Sub();
        System.out.println(s.a);
        System.out.println(((Base) s).a);
    }
}
