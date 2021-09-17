package com.itheima.controller;

import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.controller
 *
 * @author Leevi
 * 日期2020-11-11  11:02
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    public List<Account> findAll() throws SQLException {
        return accountService.findAll();
    }

    public Account findById(int id) throws SQLException {
        return accountService.findById(id);
    }

    public void deleteById(int id) throws SQLException {
        accountService.deleteById(id);
    }

    public void add(Account account) throws SQLException {
        accountService.add(account);
    }

    public void update(Account account) throws SQLException {
        accountService.update(account);
    }
}
