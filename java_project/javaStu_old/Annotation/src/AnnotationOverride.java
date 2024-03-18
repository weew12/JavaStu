/**
 * @Classname Annotation_Override
 * @Description
 *              Annotation : @Override
 *              编译器会检查被@Override注解的方法
 *              确保该方法父类中存在的方法
 *              否则会有编译错误
 * @Date 2019-09-27
 * @Created by 枫weew12
 */
public class AnnotationOverride {

    public static void main(String[] args) {

        Person Jack = new Person("Jack", 18);
        System.out.println(Jack);
    }
}

class Person {
    private String name;
    private int age;

    Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

//    父类无此方法t0String() 报错
//    @Override
//    public String t0String() {
//        return "Person [name=" + name + ", age=" + age + "]";
//    }

}