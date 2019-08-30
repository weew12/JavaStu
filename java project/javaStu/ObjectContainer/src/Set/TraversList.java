package Set;

/**
 * @Classname TraversList
 * @Description
 * @Date 2019-08-30
 * @Created by 枫weew12
 */
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class TraversList {

    public static void main(String[] args) {

        Set set = new HashSet();

        String b = "B";

        //添加元素到集合
        set.add("A");
        set.add(b);
        set.add("C");
        set.add(b);
        set.add("D");
        set.add("E");

        // for-each 遍历
        System.out.println("使用 for-each 遍历");
        for (Object item: set) {
            String s = (String)item;
            System.out.println("读取集合元素: " + s);
        }

        // 使用迭代器遍历
        System.out.println("使用迭代器遍历");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            String s = (String)item;
            System.out.println("读取集合元素: " + s);
        }
    }
}
