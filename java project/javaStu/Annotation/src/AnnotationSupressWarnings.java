/**
 * @Classname AnnotationSupressWarnings
 * @Description
 * @Date 2019-09-27
 * @Created by 枫weew12
 */
public class AnnotationSupressWarnings {

    @SuppressWarnings({ "deprecation" })
    public static void main(String[] args) {

        Person_2 Alice = new Person_2();
        Alice.setNameAndAge("Alice", 17);
        String name = Alice.getName();
        int age = Alice.getAge();
        System.out.println("name = " + name + "age = " + age);
        System.out.println(Alice);

    }
}

@Deprecated
class Person_2 {

    @Deprecated
    protected String name;
    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Deprecated
    public void setNameAndAge(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}