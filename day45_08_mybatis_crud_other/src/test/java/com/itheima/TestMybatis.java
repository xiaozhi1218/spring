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
 * @author Leevi
 * 日期2020-11-11  11:08
 * 单元测试方法其实是在Junit框架中的main方法的执行的
 * 之前我们都要自己创建核心容器
 * 我们如果能够让Junit帮我们创建核心容器:使用spring整合Junit
 * 1. 引入spring整合Junit的依赖
 * 2. junit的版本一定要是4.12以及以上的版本
 * 3. 让我们的测试类依赖spring整合的Junit运行, 添加@RunWith(SpringJUnit4ClassRunner.class)
 * 4. 让Junit知道需要去加载哪个配置文件或者哪个配置类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TestMybatis {
    @Autowired
    private AccountController accountController;

    @Test
    public void testFindAll() throws SQLException {
        System.out.println(accountController.findAll());
    }

    @Test
    public void testFindById() throws SQLException {
        System.out.println(accountController.findById(1));
    }
}
