package site.weew12.chapter11;

/**
 * StringBuilder测试
 * @author weew12
 */
public class StringBuildTest {

    public static void test1() {
        StringBuilder s = new StringBuilder("helloworld");
        System.out.println(s);
        s.setLength(30);
        System.out.println(s);
    }

    /*
    测试StringBuffer和StringBuilder的效率差异
     */
    public static void test2() {
        long startTime = 0L;
        long endTime = 0L;

        String textString = "";
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        // 测试String
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            textString += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String 20000 rounds CostTime:" + (endTime - startTime));
        // 测试StringBuffer
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            stringBuffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer 20000 rounds CostTime:" + (endTime - startTime));
        // 测试StringBuilder
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            stringBuilder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder 20000 rounds CostTime:" + (endTime - startTime));

    }
    public static void main(String[] args) {
//        test1();
        test2();
    }
}
