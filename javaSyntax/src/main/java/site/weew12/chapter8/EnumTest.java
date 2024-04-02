package site.weew12.chapter8;

/**
 * 枚举enum测试
 *
 * @author weew12
 */
public class EnumTest {
    public static void main(String[] args) {
        Week[] values = Week.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            System.out.println(values[i].toString());
            System.out.println(Week.valueOf(values[i].toString()));
            System.out.println(values[i].ordinal());
        }
    }
}

enum Week {
    /**
     *
     */
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");

    private final String description;

    private Week(String description) {
        this.description = description;
    }

//    @Override
//    public String toString() {
//        return super.toString() + ":" + description;
//    }
}
