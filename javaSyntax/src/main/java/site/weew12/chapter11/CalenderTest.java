package site.weew12.chapter11;

import com.sun.security.jgss.GSSUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日历Calender测试
 *
 * @author weew12
 */
public class CalenderTest {

    public static void test1() {
        Calendar c = Calendar.getInstance();
        System.out.println(c);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        System.out.println(" year: " + year + " month: " + month + " day: " + day
                + " hour: " + hour + " minutes: " + minute + " seconds: " + second);
    }

    public static void test2() {
        TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
        Calendar c = Calendar.getInstance(timeZone);
//        System.out.println(c);
    }

    public static void test3() {

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        System.out.println("Before:==================");
        System.out.println(calendar.getTime());


        date = new Date(234234235235L);
        calendar.setTime(date);
        System.out.println("After:===================");
        System.out.println(calendar.getTime());

        calendar.set(Calendar.DAY_OF_MONTH, 8);
        System.out.println("set 8 month:================");
        System.out.println(calendar.getTime());

        calendar.add(Calendar.HOUR, 2);
        System.out.println("add 2 hour:=================");
        System.out.println(calendar.getTime());

        calendar.add(Calendar.MONTH, -2);
        System.out.println("add -2 month:================");
        System.out.println(calendar.getTime());
    }

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
    }
}
