package com.itheima.controller;

import com.itheima.pojo.Account;
import com.itheima.service.AccountService;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.controller
 *
 * @author Leevi
 * 日期2020-11-10  15:15
 */
public class AccountController {
    private AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public List<Account> findAll(){
        try {
            return accountService.findAll();
        } catch (SQLException throwables) {
            throw new RuntimeException("服务器异常");
        }
    };
}
