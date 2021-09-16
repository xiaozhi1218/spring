package com.itheima.service;

import com.itheima.pojo.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.service
 *
 * @author Leevi
 * 日期2020-11-10  15:17
 */
public interface AccountService {
    List<Account> findAll() throws SQLException;

}
