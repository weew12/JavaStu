package Map;

/**
 * @Classname TestMap
 * @Description
 * @Date 2019-08-30
 * @Created by 枫weew12
 */
import java.util.HashMap;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {

        Map map = new HashMap();

        map.put(101, "张三");
        map.put(102, "李四");
        map.put(103, "王五");
        map.put(104, "董六");

        //"李四"值重复
        map.put(105, "李四");
        //103键已经存在， 替换原来值"王五"
        map.put(103, "刘备");

        // 打印集合元素个数
        System.out.println("集合 size = " + map.size());
        // 打印集合
        System.out.println(map);

        // 通过键取值
        System.out.println("103 - " + map.get(103));
        System.out.println("108 - " + map.get(108));

        // 删除键值对
        map.remove(103);
        // 判断键集合中是否包含103
        System.out.println("键集合中是否包含103： " + map.containsKey(103));
        // 判断值集合中是否包含 "李四"
        System.out.println("值集合中是否包含王五： " + map.containsValue("王五"));

        // 判断集合是否为空
        System.out.println("集合是空的 : " + map.isEmpty());

        // 清空集合
        map.clear();
        System.out.println(map);
    }
}
