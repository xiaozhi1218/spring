package com.itheima.dao;

import com.itheima.pojo.Account;

import java.util.List;

/**
 * 包名:com.itheima.dao
 *
 * @author Leevi
 * 日期2020-11-12  14:47
 */
public interface AccountDao {
    List<Account> findAll();

    void add();

    Account findById(int id);
}
