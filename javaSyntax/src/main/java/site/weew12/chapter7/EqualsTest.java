package site.weew12.chapter7;

/**
 * == 和 equals的使用和原理
 * @author weew12
 */
public class EqualsTest {
    public static void main(String[] args) {
        int it = 65;
        float fl = 65.0f;
        // true  比较值
        System.out.println("65和65.0f是否相等？" + (it == fl));

        char ch1 = 'A';
        char ch2 = 12;
        // true    比较值
        System.out.println("65和'A'是否相等？" + (it == ch1));
        // true    比较值// true    比较值
        System.out.println("12和ch2是否相等？" + (12 == ch2));

        String str1 = new String("hello");
        String str2 = new String("hello");
        // false  比较字符串对象的地址是否相同
        System.out.println("str1和str2是否相等？"+ (str1 == str2));
        //true    比较字符串的内容是否相同
        System.out.println("str1是否equals str2？"+(str1.equals(str2)));

// 不可比较 编译不通过
//        System.out.println("hello" == new java.util.Date());
    }
}
