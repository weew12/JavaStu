package site.weew12.chapter7;

/**
 * finalize()方法测试
 * @author weew12
 */
public class FinalizeTest {
    public static void main(String[] args) {
        People person = new People("tom", 15);
        System.out.println(person);
        person = null;
//        强制调用gc清理，触发finalize()方法
        System.gc();
    }
}


class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() method has been invoked...");
    }

}