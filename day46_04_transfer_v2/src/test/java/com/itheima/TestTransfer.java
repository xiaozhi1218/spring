package com.itheima;

import com.itheima.controller.AccountController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 包名:com.itheima
 * @author Leevi
 * 日期2020-11-12  11:02
 * 使用spring的事务管理者来进行事务控制
 * 第一种方式: 编程式事务，将spring管理事务的代码写在业务代码里面进行事务管理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class TestTransfer {
    @Autowired
    private AccountController accountController;
    @Test
    public void test01(){
        accountController.transfer("aobama","jay",520.0);
    }
}
