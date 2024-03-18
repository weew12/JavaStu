package interface_;

/**
 * @Classname Interface_
 * @Description
 * @Date 2019-08-30-10:44
 * @Created by 枫weew12
 */
public class Interface_ {
    public static void main(String[] args) {

        // 定义父类对象引用 指向子类示例 发生多态
        Figure ellipse = new Ellipse();
        ellipse.onDraw();

        System.out.println(ellipse.name);
        System.out.println(Figure.name);

        Figure triangle = new Triangle();
        triangle.onDraw();

    }
}

interface Figure {
    // 接口的静态成员变量
    String name = "几何图形"; // public static final 可省略

    // 绘图方法 public 可略
    void onDraw();
}

class Ellipse implements Figure {

    // 实现方法
    @Override
    public void onDraw() {
        System.out.println("绘制椭圆2...");
    }
}

class Triangle implements Figure {

    // 实现方法
    @Override
    public void onDraw() {
        System.out.println("绘制三角形2...");
    }
}
