package com.weew12.jpetstore.domain;

/**
 * @Classname Account
 * @Description
 *              账户
 * @Date 2019-09-29
 * @Created by 枫weew12
 */
public class Account {

    private String userid; //用户id
    private String password; //用户密码
    private String email; //用户邮箱
    private String username; //用户名
    private String addr; //地址
    private String city; //所在城市
    private String country; //国家
    private String phone; //电话号码

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
