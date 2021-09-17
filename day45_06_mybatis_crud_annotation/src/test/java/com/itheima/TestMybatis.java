package com.itheima;

import com.itheima.controller.AccountController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

/**
 * 包名:com.itheima
 *
 * @author Leevi
 * 日期2020-11-11  11:08
 */
public class TestMybatis {

    @Test
    public void testFindAll() throws SQLException {
        //创建核心容器，指定要加载的配置类
        ApplicationContext act = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //从核心容器中获取对象
        AccountController accountController = (AccountController) act.getBean("accountController");
        System.out.println(accountController.findAll());
    }
}
