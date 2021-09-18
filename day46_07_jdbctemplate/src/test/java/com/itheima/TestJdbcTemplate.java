package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 包名:com.itheima
 *
 * @author Leevi
 * 日期2020-11-12  14:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class TestJdbcTemplate {
    @Autowired
    private AccountDao accountDao;

    @Test
    public void testFindAll(){
        List<Account> accountList = accountDao.findAll();
        System.out.println(accountList);
    }

    @Test
    public void testAdd(){
        accountDao.add();
    }

    @Test
    public void testFindById(){
        System.out.println(accountDao.findById(1));
    }
}
