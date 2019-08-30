package multiple_inheritance;

/**
 * @Classname MultiInterface
 * @Description
 *              : java 支持单继承不支持多继承
 *                为了避免继承的类中包含相同的方法引起冲突
 *                通过实现多个接口来实现多继承的设计
 *
 * @Date 2019-08-30
 * @Created by 枫weew12
 */
public class MultiInterface {

    public static void main(String[] args) {

        AB test = new AB();
        test.methodA();
        test.methodB();
        test.methodC();
    }
}

interface A {
    void methodA();
    void methodB();
}

interface B {
    void methodB();
    void methodC();
}

class AB implements A, B {

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