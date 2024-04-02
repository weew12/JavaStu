package site.weew12.chapter7;

class Creature {
    {
        System.out.println("Creature block...");
    }
    static {
        System.out.println("Creature static block...");
    }
    public Creature() {
        System.out.println("Creature无参数的构造器");
    }
}
class Animal extends Creature {
    {
        System.out.println("Animal block...");
    }
    static {
        System.out.println("Animal static block...");
    }
    public Animal(String name) {
        System.out.println("Animal带一个参数的构造器，该动物的name为" + name);
    }
    public Animal(String name, int age) {
        this(name);
        System.out.println("Animal带两个参数的构造器，其age为" + age);
    }
}

/**
 * 子类对象实例化的全程
 * @author weew12
 */
public class Dog extends Animal {
    {
        System.out.println("Dog block...");
    }
    static {
        System.out.println("Dog static block...");
    }
    public Dog() {
        super("汪汪队阿奇", 3);
        System.out.println("Dog无参数的构造器");
    }
    public static void main(String[] args) {
        new Dog();
    }
}