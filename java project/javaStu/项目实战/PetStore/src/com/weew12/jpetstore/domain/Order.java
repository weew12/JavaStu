package com.weew12.jpetstore.domain;

/**
 * @Classname Order
 * @Description
 *              订单
 * @Date 2019-09-29
 * @Created by 枫weew12
 */
import java.util.Date;

public class Order {

    private long orderid;//订单id
    private String userid;//下单用户id
    private Date orderdate;//下单时间
    private int status;//订单付款状态
    private double amount;//订单应付款金额

    public long getOrderid() {
        return orderid;
    }
    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getOrderdate() {
        return orderdate;
    }
    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
