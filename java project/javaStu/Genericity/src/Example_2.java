import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Example_2
 * @Description
 *                  在Java 5之前没有好的解决办法，
 *                  在类型转换之前要通过instanceof运算符判断一下，
 *                  该对象是否是目标类型。 而泛型的引入可以将这些运行时异常提前到编译期暴露出来，
 *                  这增强了类型安全检查
 *
 * @Date 2019-09-12
 * @Created by 枫weew12
 */
public class Example_2 {

  public static void main(String[] args) {
    //

      List<String> list = new ArrayList<String>();

      // add elements
      list.add("1");
      list.add("2");
      list.add("3");
      list.add("4");
      list.add("5");
//      list.add(new Date); //发生编译错误

      // traverse
      for (String item : list) {
          System.out.println("read elements : " + item);
      }
   }
}
