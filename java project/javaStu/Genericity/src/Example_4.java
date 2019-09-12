import java.util.*;

/**
 * @Classname Example_4
 * @Description
 * @Date 2019-09-12
 * @Created by 枫weew12
 */
public class Example_4 {

  public static void main(String[] args) {

      Map<Integer, String> map = new HashMap<Integer, String>();

      // add
      map.put(1, "小明");
      map.put(2, "小李");
      map.put(3, "小邓");

      // -- for --
      System.out.println("for traverse");
      Set<Integer> keys = map.keySet();
      for (Integer key : keys) {
          String value = map.get(key);
          System.out.printf("key=%d -- value=%s \n", key, value);
      }

      // iterator
      System.out.println("iterator traverse");
      Collection<String> values = map.values();

      Iterator<String> it = values.iterator();
      while (it.hasNext()) {
          String item = it.next();
          System.out.println("read elements :" + item);
      }
  }
}
