package com.itheima.dao;

import com.itheima.pojo.Account;

import java.util.List;

/**
 * 包名:com.itheima.dao
 * @author Leevi
 * 日期2020-11-11  14:51
 * 目标: 获取AccountDao的代理对象，执行查询所有的sql语句
 */
public interface AccountDao {
    List<Account> findAll();
}
