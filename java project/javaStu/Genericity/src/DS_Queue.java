import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DS_Queue
 * @Description
 *                  利用泛型实现队列
 *
 * @Date 2019-09-12
 * @Created by 枫weew12
 */
public class DS_Queue {

    public static void main(String[] args) {

        Queue<String> generiQueue = new Queue<String>();

        generiQueue.queue("A");
        generiQueue.queue("B");
        generiQueue.queue("C");

        System.out.println(generiQueue);

        generiQueue.dequeue();
        System.out.println(generiQueue);

    }
}

class Queue<T> {

    // 数据成员
    private List<T> items;

    // 初始化
    public Queue() {
        this.items = new ArrayList<T>();
    }

    /**
     * 入队
     * @param item 入队参数
     * */
    public void queue(T item) {
        this.items.add(item);
    }

    /**
     * 出队
     * @return 出队数据
     * */
    public T dequeue() {
        if (items.isEmpty()) {
            return null;
        } else {
            return this.items.remove(0);
        }
    }

    @Override
    public String toString() {
        return items.toString();
    }

}