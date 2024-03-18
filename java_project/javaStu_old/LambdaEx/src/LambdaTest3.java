import java.util.Arrays;
import java.util.List;

/**
 * @Classname LambdaTest3
 * @Description
 * @Date 2019-12-02
 * @Created by 枫weew12
 */
public class LambdaTest3 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        for (Integer n:list) {
            System.out.println(n);
        }
        System.out.println("--------------");

        list.forEach(n-> System.out.println(n));
        System.out.println("--------------");

        list.forEach(System.out::println);

    }
}
