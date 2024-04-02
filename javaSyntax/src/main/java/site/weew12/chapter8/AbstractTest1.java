package site.weew12.chapter8;

/**
 * abstract 测试1
 */
public class AbstractTest1 {
}


abstract class Fa {
    public abstract void fun1();
    public abstract void fun2();
}

abstract class Ma extends Fa {
    public abstract void fun3();
}

/**
 * 继承链上所有的abstract方法都必须实现
 */
class Sa extends Ma {

    @Override
    public void fun1() {

    }

    @Override
    public void fun2() {

    }

    @Override
    public void fun3() {

    }
}