
import java.lang.annotation.*;

/**
 * @Classname TheCustomAnnotation2
 * @Description
 *              自定义注解
 * @Date 2019-09-28
 * @Created by 枫weew12
 */
public class TheCustomAnnotation2 {

}

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    String description();
}

@Documented
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
@interface MemberAnnotation {
    Class<?> type() default void.class;
    String description();
}

@MyAnnotation(description = "这是一个测试类")
public class Person {
    @MemberAnnotation(type = String.class, description = "名字")
    private String name;
    @MemberAnnotation(type = int.class, description = "年龄")
    private int age;
    @MemberAnnotation(type = String.class, description = "获得名字")
    public String getName() {
        return name;
    }
    @MemberAnnotation(type = int.class, description = "获得年龄")
    public int getAge() {
        return age;
    }
//    @MemberAnnotation(description = "设置姓名和年龄")
    public void setNameAndAge(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
