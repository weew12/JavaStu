package interface_inheritance;

/**
 * @Classname InterfaceInheritance
 * @Description
 * @Date 2019-08-30
 * @Created by 枫weew12
 */
public class InterfaceInheritance {

    public static void main(String[] args) {

        ABC test = new ABC();
        test.methodA();
        test.methodB();
        test.methodC();
    }
}

interface A {
    void methodA();
    void methodB();
}

interface B extends A {

    @Override()
    void methodB();
    void methodC();
}

class ABC implements B {

    @Override
    public void methodA() {
        System.out.println("methodA");
    }

    @Override
    public void methodB() {
        System.out.println("methodB");
    }

    @Override
    public void methodC() {
        System.out.println("methodC");
    }

}