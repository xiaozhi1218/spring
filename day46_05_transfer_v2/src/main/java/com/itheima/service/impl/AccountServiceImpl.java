package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * 包名:com.itheima.service.impl
 *
 * @author Leevi
 * 日期2020-11-12  10:55
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private DataSource dataSource;

    @Override
    public void transfer(String fromName, String toName, Double money) {
        //1. 调用dao的方法进行转出账户扣款
        accountDao.updateAccount(fromName,-money);
        //int num = 10/0;
        //2. 调用dao的方法进行转入账户收款
        accountDao.updateAccount(toName,money);
    }
}
