import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * @Classname Example_3
 * @Description
 *              genericity for set
 *
 * @Date 2019-09-12
 * @Created by 枫weew12
 */
public class Example_3 {

  public static void main(String[] args) {
    //

    Set<String> set = new HashSet<String>();

    set.add("A");
    set.add("B");
    set.add("C");

    // --for--
    System.out.println("for traverse");
    for (String item:set) {
      System.out.println("read elements: " + item);
    }

    // iterator
    System.out.println("iterator traverse");
    Iterator<String> it = set.iterator();
    while (it.hasNext()) {
        String item = it.next();
        System.out.println("read elements :" + item);
    }
  }
}
