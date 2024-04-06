package site.weew12.chapter11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * Java8新的时间API
 *
 * @author weew12
 */
public class NewTimeApiTest {
    public static void test1() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
    }

    public static void test2() {
        LocalTime now = LocalTime.now();
        System.out.println(now);
    }

    public static void test3() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

    public static void test4() {
        LocalDate date = LocalDate.of(2024, 04, 03);
        System.out.println(date.getDayOfWeek());

        System.out.println("plus 3 day================");
        LocalDate plusDate = date.plusDays(3);
        System.out.println(plusDate.getDayOfWeek());

        System.out.println("minus 4 day===============");
        LocalDate minusDate = date.minusDays(4);
        System.out.println(minusDate.getDayOfWeek());
    }

    public static void test5() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String str = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str);

        TemporalAccessor parse = formatter.parse("2022-12-04T21:02:14.808");
        LocalDateTime dateTime = LocalDateTime.from(parse);
        System.out.println(dateTime);
    }

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
    }
}
