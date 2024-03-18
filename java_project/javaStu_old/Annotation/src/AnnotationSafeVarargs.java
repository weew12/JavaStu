/**
 * @Classname AnnotationSafeVarargs
 * @Description
 * @Date 2019-09-27
 * @Created by 枫weew12
 */
public class AnnotationSafeVarargs {

    public static void main(String[] args) {

        // 传递可变参数 泛型集合参数
        display(10, 20, 30);
        // 传递可变参数 非泛型集合参数
        display("10", 20, 30);
    }

    @SafeVarargs
    public static <T> void display(T ... args) {
        for (T arg: args) {
            System.out.println(arg.getClass().getName() + ":" + arg);
        }
    }
}


