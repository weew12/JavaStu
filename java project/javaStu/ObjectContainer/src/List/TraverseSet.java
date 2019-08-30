package List;

/**
 * @Classname TraverseSet
 * @Description
 * @Date 2019-08-30
 * @Created by 枫weew12
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TraverseSet {

    public static void main(String[] args) {

        List list = new ArrayList();

        String b = "B";
        // 添加元素到集合
        list.add("A");
        list.add(b);
        list.add("C");
        list.add(b);
        list.add("D");
        list.add("E");

        // for 循环遍历
        System.out.println("for 循环遍历");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("读取集合元素(%d): %s \n", i, list.get(i));
        }

        // for-each 遍历
        System.out.println("for-each 循环遍历");
        for (Object item: list) {
            String s = (String)item;
            System.out.println("读取集合元素: " + s);
        }

        // 使用迭代器遍历
        System.out.println("使用迭代器遍历");
        Iterator it = list.iterator();
        while(it.hasNext()) {
            Object item = it.next();
            String s = (String)item;
            System.out.println("读取集合元素: " + s);
        }
    }
}
