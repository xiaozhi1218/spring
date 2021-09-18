package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.service.impl
 *
 * @author Leevi
 * 日期2020-11-11  11:01
 */
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() throws SQLException {
        return accountDao.findAll();
    }

    @Override
    public Account findById(int id) throws SQLException {
        return accountDao.findById(id);
    }

    @Override
    public void deleteById(int id) throws SQLException {
        accountDao.deleteById(id);
    }

    @Override
    public void add(Account account) throws SQLException {
        accountDao.add(account);
    }

    @Override
    public void update(Account account) throws SQLException {
        accountDao.update(account);
    }
}
