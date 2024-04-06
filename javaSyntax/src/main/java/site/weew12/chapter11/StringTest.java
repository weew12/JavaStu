package site.weew12.chapter11;


/**
 * 字符串String相关特性测试
 *
 * @author weew12
 */
public class StringTest {
    public static void test1() {
        String s1 = "hello";
        String s2 = "hello";
        // true
        System.out.println(s1 == s2);
        System.out.println("s1 hashcode:" + s1.hashCode());
        System.out.println("s2 hashcode:" + s2.hashCode());
    }

    /**
     * to understand
     */
    public static void test2() {
        class Person {
            String name;
        }
        Person p1 = new Person();
        p1.name = "TOM";
        Person p2 = new Person();
        p2.name = "TOM";
        // 比较字符串的值 true
        System.out.println("p1.name.equals(p2.name)" + p1.name.equals(p2.name));
        // false
        System.out.println("p1.name == p2.name" + p1.name == p2.name);
        // false
        System.out.println("p1.name == TOM" + p1.name == "TOM");
    }

    public static void test3() {
        String str1 = "abc";
        String str2 = new String("abc");
        // false
        System.out.println(str2 == str1);
    }

    public static void test4() {
        String s1 = "javaEE";
        String s2 = "javaEE";
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");
        //true
        System.out.println(s1 == s2);
        //false
        System.out.println(s1 == s3);
        //false
        System.out.println(s1 == s4);
        //false
        System.out.println(s3 == s4);
    }

    public static void test5() {
        class StringTest5 {
            String str = new String("good");
            char[] ch = {'t', 'e', 's', 't'};

            public void change(String str, char ch[]) {
                str = "test ok";
                ch[0] = 'b';
            }
        }

        StringTest5 ex = new StringTest5();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " And ");
        System.out.println(ex.ch);
    }

    public static void main(String[] args) {
//       test1();
//        test2();
//        test3();
//        test4();
        test5();
    }
}
