/**
 * @Classname TheCustomAnnotation
 * @Description
 *              使用元注解
 * @Date 2019-09-28
 * @Created by 枫weew12
 */

@Marker
public class TheCustomAnnotation {

    @MyAnnotation(value = "weew12")
    private static String info = "";

    @MyAnnotation1(count = 1)
    public static void main(String[] args) {

    }
}

@interface Marker {

}

@interface MyAnnotation {
    String value();
}

@interface MyAnnotation1 {
    String value() default "注解信息";
    int count() default 0;
}

