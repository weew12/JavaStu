package abstract_class;

/**
 * @Classname AbstractClass
 * @Description
 *              抽象类
 *              : 抽象类不能实例化对象 只有实例类能被实例化
 *              实例类不能包含抽象方法
 *              抽象类可以包含具体方法、抽象方法
 *
 * @Date 2019-08-30-10:25
 * @Created by 枫weew12
 */
public class AbstractClass {
    public static void main(String[] args) {

        // 定义父类对象引用 指向子类示例 发生多态
        Figure ellipse = new Ellipse();
        ellipse.onDraw();

        Figure triangle = new Triangle();
        triangle.onDraw();
    }
}

/*
* 以几何图形来描述抽象类
* Figure 图形类(abstract)
* Ellipse 椭圆类
* Triangle 三角形类
* */

abstract class Figure {
    public abstract void onDraw(); //绘制图形
}

class Ellipse extends Figure {

    //实现abstract方法
    @Override
    public void onDraw() {
        System.out.println("绘制椭圆...");
    }
}

class Triangle extends Figure {

    //实现abstract方法
    @Override
    public void onDraw() {
        System.out.println("绘制三角形...");
    }
}

