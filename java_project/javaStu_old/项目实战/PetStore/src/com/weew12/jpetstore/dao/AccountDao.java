package com.weew12.jpetstore.dao;

/**
 * @Classname AccountDao
 * @Description
 * @Date 2019-09-29
 * @Created by 枫weew12
 */
import java.util.List;
import com.weew12.jpetstore.domain.Account;

//用户管理DAO
public interface AccountDao {

    // 查询所有的用户信息
    List<Account> findAll();

    // 根据主键查询用户信息
    Account findById(String userid);

    // 创建用户信息
    int create(Account account);

    // 修改用户信息
    int modify(Account account);

    // 删除用户信息
    int remove(Account account);

}
