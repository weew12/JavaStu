package site.weew12.chapter12;

import java.util.HashMap;
import java.util.Map;

/**
 * foreach 增强for循环测试
 *
 * @author weew12
 */
public class ForEachTest {
    public static void test1() {
        String[] strings = new String[]{
                "string1",
                "string2",
                "string3"
        };
        for (String string : strings) {
            string = "test string";
            System.out.println(string);
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

    public static void main(String[] args) {
        test1();
    }
}
