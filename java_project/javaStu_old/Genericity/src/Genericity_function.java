/**
 * @Classname Genericity_function
 * @Description
 * @Date 2019-09-12
 * @Created by 枫weew12
 */
public class Genericity_function {

    public static void main(String[] args) {

        System.out.println(isEquals(new Integer(1), new Integer(2)));
        System.out.println(isEquals(1, 2));
        System.out.println(isEquals(new Double(1.0), new Double(2.0)));
        System.out.println(isEquals(1.0, 2.0));
        System.out.println(isEquals("A", "B"));
    }

    public static <T> boolean isEquals(T a, T b) {
        return a.equals(b);
    }
}


////限定参数
//public class Genericity_function {
//
//    public static void main(String[] args) {
//
//        System.out.println(isEquals(new Integer(1), new Integer(2)));
//        System.out.println(isEquals(1, 2));
//        System.out.println(isEquals(new Double(1.0), new Double(2.0)));
//        System.out.println(isEquals(1.0, 2.0));
//        System.out.println(isEquals("A", "B"));
//    }
//
//    public static <T extends Number> boolean isEquals(T a, T b) {
//        return a.equals(b);
//    }
//}