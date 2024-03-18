/**
 * @Classname Test2
 * @Description
 *              静态内部类
 * @Date 2019-10-10
 * @Created by 枫weew12
 */
public class Test2 {

    public static void main(String[] args) {

        // 直接访问内部类
        View.Button button = new View.Button();
        button.onClick();
    }
}

//外部类
class View {

    // 外部类实例变量
    private int x = 20;

    // 外部类静态变量
    private static int staticX = 10;

    // 静态内部类
    static class Button {

        // 内部类方法
        void onClick() {

            //访问外部类的静态成员
            System.out.println(staticX);
            //不能访问外部类的非静态成员
            // System.out.println(x); //编译错误
        }
    }
}