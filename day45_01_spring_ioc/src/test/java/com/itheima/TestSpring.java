package com.itheima;

import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 包名:com.itheima
 * @author Leevi
 * 日期2020-11-10  10:59
 * 使用spring进行IOC:
 * 1.由spring的核心容器去加载spring的配置文件，从而创建出使用者想要的所有对象，存储到核心容器
 * 2.再调用核心容器的方法，传入对象的id，从而获取对象
 *
 * Spring的IOC的使用步骤:
 * 1. 引入依赖
 * 2. 编写配置文件，要创建对象的类就对应一个bean标签
 * 3. 在要使用对象的地方，创建核心容器指定要加载的配置文件，然后调用核心容器的getBean(id)获取对象
 */
public class TestSpring {
    @Test
    public void test01(){
        //创建UserService的实现类对象，执行addUser方法
        //1. 创建spring的核心容器对象，指定要加载的配置文件
        ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");
        //2. 从核心容器中根据id获取对象
        UserService userService = (UserService) act.getBean("userService");

        userService.addUser();
    }
}
