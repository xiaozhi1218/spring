package com.itheima;

import com.itheima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 包名:com.itheima
 *
 * @author Leevi
 * 日期2020-11-12  08:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-aop.xml")
public class TestAop {
    @Autowired
    private UserService userService;
    @Test
    public void test01(){
        System.out.println(userService.query());
    }
}
