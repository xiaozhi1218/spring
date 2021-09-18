package com.itheima.controller;

import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 包名:com.itheima.controller
 *
 * @author Leevi
 * 日期2020-11-12  10:53
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    /**
     * 转账方法
     * @param fromName
     * @param toName
     * @param money
     */
    public void transfer(String fromName,String toName,Double money){
        accountService.transfer(fromName,toName,money);
    }
}
