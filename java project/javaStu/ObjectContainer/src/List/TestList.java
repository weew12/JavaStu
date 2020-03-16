package List;

/**
 * @Classname TestSet
 * @Description
 * @Date 2019-08-30
 * @Created by 枫weew12
 */
import java.util.ArrayList;
import java.util.List;

public class TestSet {

    public static void main(String[] args) {

        List list = new ArrayList();

        String b = "B";

        //向集合中添加元素
        list.add("A");
        list.add(b);
        list.add("C");
        list.add(b);
        list.add("D");
        list.add("E");

        //打印集合元素个数
        System.out.println("集合size = " + list.size());
        //打印集合
        System.out.println(list);

        //从前往后查找集合中的"B"元素
        System.out.println("indexOf(\"B\") = " + list.indexOf(b));
        //从后往前查找集合中的"B"元素
        System.out.println("lastIndexOf(\"B\") = " + list.lastIndexOf(b));

        //删除集合中第一个"B"元素
        list.remove(b);
        System.out.println("remove(3)前： " + list);
        //判断集合中是否包含"B"元素
        System.out.println("是否包含\"B\"： " + list.contains(b));

        //删除集合第4个元素
        list.remove(3);
        System.out.println("remove(3)后： " + list);
        //判断集合是否为空
        System.out.println("list集合是空的： " + list.isEmpty());
        System.out.println("替换前： " + list);

        //替换集合第2个元素
        list.set(1, "F");
        System.out.println("替换后： " + list);

        //清空集合
        list.clear();
        System.out.println(list);

        // 重新添加元素
        list.add(1);//发生自动装箱
        list.add(3);
        int item = (Integer)list.get(0);//发生自动拆箱
    }
}
