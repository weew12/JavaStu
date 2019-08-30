package java8_newfeatures;

/**
 * @Classname Java8NewFeatures
 * @Description
 *              : Java 8在接口中提供了声明默认方法和静态方法的能力
 *              调用接口静态方法， 只能通过接口名（InterfaceA） 调用， 不能通过实现类调用，
 *              可以这样理解接口中声明的静态方法与其他实现类没有任何关系
 *
 * @Date 2019-08-30
 * @Created by 枫weew12
 */
public class Java8NewFeatures {

    public static void main(String[] args) {

        InterfaceA abc = new ABC();

        System.out.println(abc.methodB());
        System.out.println(abc.methodC());
        System.out.println(abc.methodD());
        System.out.println(InterfaceA.methodE());


    }
}

interface InterfaceA {
    // 抽象方法
    void methodA();
    String methodB();

    // 默认方法
    default int methodC() {
        return 0;
    }

    default String methodD() {
        return "这是默认方法...";
    }

    // 静态方法
    static double methodE() {
        return 0.0;
    }

}

class ABC implements InterfaceA {

    @Override
    public void methodA() {
    }

    @Override
    public String methodB() {
        return "实现methodB方法...";
    }

    @Override
    public int methodC() {
        return 666;
    }
}