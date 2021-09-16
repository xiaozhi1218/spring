package com.itheima;

import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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
 *
 * Spring核心容器中的对象什么时候创建，什么时候销毁:
 * 对象的创建
 * 1. 如果是单例:
 *    1.1 懒加载: 在调用核心容器的getBean()方法的时候创建
 *    1.2 不懒加载: 在核心容器创建的时候就创建对象
 * 2. 如果是多例: 都是在调用核心容器的getBean()方法的时候创建
 *
 * 对象的销毁
 * 1. 如果对象是在核心容器里面的(单例),那么只有在核心容器销毁的时候，对象才销毁
 * 2. 如果对象不是在核心容器里面(多例)，那么对象会在每标记为垃圾之后，有GC进行回收
 */
public class TestSpring {
    @Test
    public void test01(){
        //创建UserService的实现类对象，执行addUser方法

        //1. 创建spring的核心容器对象，指定要加载的配置文件
        //ClassPathXmlApplicationContext是spring的核心容器实现类
        ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");

        //2. 从核心容器中根据id获取你想要的对象
        UserService userService = (UserService) act.getBean("anotherUserService");
        //多态的作用: 1.解耦  2.扩展

        userService.addUser();
    }

    @Test
    public void test02(){
        ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");

        UserService userService1 = (UserService) act.getBean("userServiceImpl");
        UserService userService2 = (UserService) act.getBean("userServiceImpl");
        System.out.println(userService1 == userService2);
    }

    @Test
    public void test03(){
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");

        UserService userService1 = (UserService) act.getBean("anotherUserService");

        //act.close();

        userService1 = null;
    }

    @Test
    public void test04(){
        //加载磁盘中的指定路径的配置文件
        ApplicationContext act = new FileSystemXmlApplicationContext("D:\\spring.xml");

        UserService userServiceImpl = (UserService) act.getBean("userServiceImpl");
        userServiceImpl.addUser();
    }

    @Test
    public void test05(){
        //对比BeanFactory的实现类，和ApplicationContext的实现类
        Resource resource = new ClassPathResource("spring.xml");
        //创建核心容器
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        //调用核心容器的getBean方法
        UserService userService = (UserService) beanFactory.getBean("anotherUserService");
        UserService userService2 = (UserService) beanFactory.getBean("anotherUserService");
        userService.addUser();
    }
}
