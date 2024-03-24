package site.weew12.others;

/**
 *
 * 测试java输出ansi控制字符的效果
 */
public class ansiControlTest {
    public static void main(String[] args) {
        int round = 9;
        for (int i = 0; i < round; i++) {
            System.out.println("\033[3" + i + "m " + i + "this is a test string \033[0m");
        }

        int round2 = 9;
        for (int i = 0; i < round; i++) {
            System.out.println("\033[4" + i + "m " + i + "this is a test string \033[0m");
        }
    }
}
