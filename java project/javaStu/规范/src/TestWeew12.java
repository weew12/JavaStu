/**
 * @Description
 * @auther 枫weew12
 * @create 2019-07-31
 */


/**
 * 命名规范
 * 小驼峰： 首个单词小写 后续单词首字母大写
 * 大驼峰： 所有首字母大写
 *
 * 类名、接口、文件名：大驼峰
 * 方法、变量：小驼峰
 * 常量：全部大写 单词下划线隔开
 * 包名：全部小写
 * 示例代码----
 *           |
 *           |
 * */

package com.weew12;

public class TestWeew12{
    private static final String DEFAULT_CONST_VAR = "CONST_VAR";

    public static void main(String[] args) {
        TestWeew12 testObject = new TestWeew12();
        String theVarString = testObject.getString();
        System.out.println("the get string: "+theVarString);
    }

    public static String getString(){
        String theVar = new String("this is the test for naming notions!");
        return theVar;
    }
}

