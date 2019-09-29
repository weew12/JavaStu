package com.weew12.jpetstore.ui;

/**
 * @Classname MainApp
 * @Description
 * @Date 2019-09-29
 * @Created by 枫weew12
 */
import com.weew12.jpetstore.domain.Account;

//启动类
public class MainApp {
    // 用户登录成功后， 保存当前用户信息
    public static Account accout;
    public static void main(String[] args) {
        LoginFrame frame = new LoginFrame();
        frame.setVisible(true);
    }
}