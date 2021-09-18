package com.itheima;

import com.itheima.controller.AccountController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

/**
 * 包名:com.itheima
 *
 * @author Leevi
 * 日期2020-11-12  10:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class TestDataSource {
    @Autowired
    private AccountController accountController;
    @Test
    public void test01() throws SQLException {
        System.out.println(accountController.findAll());
    }
}
