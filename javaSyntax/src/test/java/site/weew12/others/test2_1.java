package site.weew12.others;

import org.junit.Test;

import java.util.*;

public class test2_1 {
    /**
     * 泛型在List中的使用
     */
    @Test
    public void test1() {
        // 将学生成绩保存到ArrayList中
        ArrayList<Integer> list = new ArrayList<>();
        list.add(56);
        list.add(76);
        list.add(88);
        list.add(89);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer score = iterator.next();
            System.out.println(score);
        }
    }

    /**
     * 泛型在Map中的使用
     */
    @Test
    public void test2() {
        HashMap<String, Integer> scores = new HashMap<>();

        scores.put("Tom", 67);
        scores.put("Jim", 56);
        scores.put("Rose", 88);

        Set<Map.Entry<String, Integer>> items = scores.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = items.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> item = iterator.next();
            String key = item.getKey();
            Integer value = item.getValue();
            System.out.println(key + " " + value);
        }
    }

    /**
     * 练习1：
     * <p>
     * （1）创建一个ArrayList集合对象，并指定泛型为 Integer
     * <p>
     * （2）添加5个[0,100)以内的整数到集合中
     * <p>
     * （3）使用foreach遍历输出5个整数
     * <p>
     * （4）使用集合的removeIf方法删除偶数，为Predicate接口指定泛型 Integer
     * <p>
     * （5）再使用Iterator迭代器输出剩下的元素，为Iterator接口指定泛型 Integer
     */
    @Test
    public void test3() {
        // 1
        ArrayList<Integer> list = new ArrayList<>();
        // 2
        for (int i = 0; i < 5; i++) {
            list.add((int) (Math.random() * 100));
        }
        // 3
        for (Integer integer : list) {
            System.out.println(integer);
        }
        String line = "==";
        System.out.println(line.repeat(5));
        // 4
        list.removeIf(integer -> integer % 2 == 0);
        // 5
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}