package com.itheima.dao;

import com.itheima.pojo.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.dao
 *
 * @author Leevi
 * 日期2020-11-10  15:18
 */
public interface AccountDao {
    List<Account> findAll() throws SQLException;

}
