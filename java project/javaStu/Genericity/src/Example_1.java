import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Example_1
 * @Description
 *              java.lang.ClassCastException:
 *              java.lang.String cannot be cast to java.lang.Integer
 *              强制类型转换是有风险的
 *              如果不进行判断就臆断进行类型转换会发生ClassCastException异常
 *
 * @Date 2019-09-12
 * @Created by 枫weew12
 */
public class Example_1 {

  public static void main(String[] args) {
    //

      List list = new ArrayList();

      // add elements
      list.add("1");
      list.add("2");
      list.add("3");
      list.add("4");
      list.add("5");

      // traverse
      for (Object item : list) {
          Integer element = (Integer) item;
          System.out.printf("read elements: " + element);
      }

  }
}
