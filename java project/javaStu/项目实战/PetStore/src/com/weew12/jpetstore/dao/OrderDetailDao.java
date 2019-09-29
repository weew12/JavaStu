package com.weew12.jpetstore.dao;

/**
 * @Classname OrderDetailDao
 * @Description
 * @Date 2019-09-29
 * @Created by 枫weew12
 */
import java.util.List;
import com.weew12.jpetstore.domain.OrderDetail;

//订单明细管理DAO
public interface OrderDetailDao {

    // 查询所有的订单明细信息
    List<OrderDetail> findAll();

    // 根据主键查询订单明细信息
    OrderDetail findByPK(int orderid, String productid);

    // 创建订单明细信息
    int create(OrderDetail orderDetail);

    // 修改订单明细信息
    int modify(OrderDetail orderDetail);

    // 删除订单明细信息
    int remove(OrderDetail orderDetail);
}

