package Map;

/**
 * @Classname TraversMap
 * @Description
 * @Date 2019-08-30
 * @Created by 枫weew12
 */
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.Collection;
import java.util.HashMap;

public class TraversMap {

    public static void main(String[] args) {

        Map map = new HashMap();

        map.put(102, "张三");
        map.put(105, "李四");
        map.put(109, "王五");
        map.put(110, "董六");
        map.put(111, "李四");

        // for-each 遍历
        System.out.println("使用for-each 遍历");
        // 获取键集合
        Set keys = map.keySet();
        for (Object item: keys) {
            int ikey = (Integer)item; // 自动拆箱 intValue()
            String value = (String)map.get(ikey); // 自动装箱 ValueOf()
            System.out.printf("key=%d - value=%s \n", ikey, value);
        }

        // 使用迭代器遍历
        System.out.println("使用迭代器遍历");
        // 获取值集合
        Collection values = map.values();
        // 遍历值集合
        Iterator it = values.iterator();
        while(it.hasNext()) {
            Object item = it.next();
            String s = (String)item;
            System.out.println("值集合元素: " + s);
        }
    }
}
