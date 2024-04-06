package site.weew12.chapter11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化与解析
 * SimpleDateFormat
 *
 * @author weew12
 */
public class SimpleDateFormatTest {
    /**
     * 获取时间并使用SimpleDateFormat格式化
     * format
     */
    public static void test1() {
        Date d = new Date();
        // E表示星期几的英文缩写 Z表示时区
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 SSSS毫秒 E Z");
        String formatTime = sf.format(d);
        System.out.println(formatTime);
    }

    /**
     * 使用SimpleDateFormat解析日期字符串
     * parse
     */
    public static void test2() {
        String formatStr = "2024年04月04日 15时14分13秒 星期四 +0800";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E Z");
        Date d = null;
        try {
            d = sf.parse(formatStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(d);
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }
}
