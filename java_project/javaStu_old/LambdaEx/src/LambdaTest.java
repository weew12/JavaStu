/**
 * @Classname LambdaTest
 * @Description
 * @Date 2019-12-02
 * @Created by 枫weew12
 */

@FunctionalInterface
interface TestLambda {
    void TestFun();
}

public class LambdaTest {

    public static void main(String[] args) {
        /*
        * 通过匿名类调用TestFun()*/
        TestLambda testlambda = new TestLambda() {
            @Override
            public void TestFun() {
                System.out.println("直接使用匿名类实现");
            }
        };
        testlambda.TestFun();

        /*
        * 通过Lambda表达式调用*/
        TestLambda testLambda2 = () -> System.out.println("使用Lambda表达式实现");
        testLambda2.TestFun();
    }
}
