import java.util.List;
import java.util.ArrayList;

/**
 * @Classname Genericity_interface
 * @Description
 * @Date 2019-09-12
 * @Created by 枫weew12
 */
public class Genericity_interface {

    public static void main(String[] args) {

        ListQueue<String> generiQueue = new ListQueue<String>();

        generiQueue.queue("A");
        generiQueue.queue("B");
        generiQueue.queue("C");

        System.out.println(generiQueue);

        generiQueue.dequeue();
        System.out.println(generiQueue);

    }
}

interface IQueue<T> {
    /**
     * 入队方法
     * @param item 参数需要入队的元素
     */
    public void queue(T item);

    /**
     * 出队方法
     * @return 返回出队元素
     */
    public T dequeue();
}

/**
 * 自定义的泛型队列集合
 */
class ListQueue<T> implements IQueue<T> {
    // 声明保存队列元素集合items
    private List<T> items;
    // 构造方法初始化是集合items
    public ListQueue() {
        this.items = new ArrayList<T>();
    }
    /**
     * @param item
     * 参数需要入队的元素
     * */
    @Override
    public void queue(T item) {
        this.items.add(item);
    }
    /**
     * 出队方法
     * @return 返回出队元素
    */
    @Override
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