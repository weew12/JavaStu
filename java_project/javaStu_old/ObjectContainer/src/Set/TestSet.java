package Set;

/**
 * @Classname TestSet
 * @Description
 * @Date 2019-08-30
 * @Created by 枫weew12
 */
import java.util.HashSet;
import java.util.Set;

public class TestSet {

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

        // 打印元素个数
        System.out.println("集合size = " + set.size());
        // 打印集合
        System.out.println(set);

        // 删除第一个 B
        set.remove(b);
        // 判断集合中是否包含"B"元素
        System.out.println("是否包含\"B\"： " + set.contains(b));
        // 判断集合是否为空
        System.out.println("set集合是空的： " + set.isEmpty());
        // 清空集合
        set.clear();
        System.out.println(set);
    }
}
