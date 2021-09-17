package com.itheima;

import com.itheima.controller.AccountController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 包名:com.itheima
 *
 * @author Leevi
 * 日期2020-11-10  15:25
 */
public class TestCRUD {
    @Test
    public void test01(){
        //1. 创建spring的核心容器
        ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");

        //2. 从核心容器中获取对象
        AccountController accountController = (AccountController) act.getBean("accountController");
        System.out.println(accountController.findAll());
    }
}
