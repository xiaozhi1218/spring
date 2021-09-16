package com.itheima;

import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 包名:com.itheima
 * @author Leevi
 * 日期2020-11-10  10:59
 */
public class TestSpring {
    @Test
    public void test01(){
        //创建核心容器对象
        ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");
        //从核心容器对象中获取UserService的实现类对象
        UserService userService = (UserService) act.getBean("userService");

        userService.addUser();
    }
}
