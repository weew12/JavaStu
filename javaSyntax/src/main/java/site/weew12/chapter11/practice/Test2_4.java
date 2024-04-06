package site.weew12.chapter11.practice;

/**
 * 2.4练习测试
 * @author weew12
 */
public class Test2_4 {
    public static void main(String[] args) {
        String str = null;
//        System.out.println(str);

        StringBuilder sb = new StringBuilder();
        sb.append(str);

        System.out.println(sb.length());
        System.out.println(sb);
        System.out.println("=====================");
//        StringBuffer sb1 = new StringBuffer(str); // 不行，空指针异常
//        System.out.println(sb1);
    }
}
