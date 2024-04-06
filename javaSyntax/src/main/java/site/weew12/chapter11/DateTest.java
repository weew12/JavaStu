package site.weew12.chapter11;

import java.util.Date;

/**
 * 日期时间API
 *
 * @author weew12
 */
public class DateTest {
    public static void test1() {
        Date d = new Date();
        System.out.println(d);
    }

    public static void test2() {
        long time = System.currentTimeMillis();
        System.out.println(time);

        Date d = new Date();
        long time2 = d.getTime();
        System.out.println(time2);
    }

    public static void test3() {
        long time = 1559807047979L;
        Date d = new Date(time);
        System.out.println(d);
    }

    public static void test4() {
        long time = Long.MAX_VALUE;
        Date d = new Date(time);
        System.out.println(d);
    }

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }
}
