package com.itheima;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.BeanFactory2;
import com.itheima.utils.BeanFactory3;
import org.junit.Test;
/**
 * 包名:com.itheima
 *
 * @author Leevi
 * 日期2020-11-10  09:48
 * 解耦的三大要素:
 * 1. 接口: =左边使用接口类型接收
 * 2. 反射: =右边使用反射创建对象
 * 3. 要写死的数据，放在配置文件中
 * 封装: 一个工具类，在工具类中使用反射创建对象
 */
public class TestFactory {
    @Test
    public void test01(){
        //1. 创建UserService的实现类对象
        UserServiceImpl userService = new UserServiceImpl();
        //2. 调用它的addUser方法
        userService.addUser();
    }

    @Test
    public void test02(){
        //1. 创建UserService的实现类对象
        UserService userService = new UserServiceImpl();
        //2. 调用它的addUser方法
        userService.addUser();
    }

    @Test
    public void test03() throws Exception {
        //1. 创建UserService的实现类对象
        UserService userService = (UserService) Class.forName("com.itheima.service.impl.UserServiceImpl").newInstance();
        //2. 调用它的addUser方法
        userService.addUser();
    }

    @Test
    public void test04(){
        //编译时异常:编译时必须处理的异常，也就是写代码的时候会报错的异常
        //运行时异常:编译时可以不处理的异常，到了代码运行的时候如果出现异常才报错
        UserService userService = (UserService) BeanFactory.createBean("com.itheima.service.impl.AnotherUserService");

        userService.addUser();
    }

    @Test
    public void test05(){
        UserService userService = (UserService) BeanFactory.createBean("anotherUserService");
        userService.addUser();
    }

    @Test
    public void test06(){
        UserService userService1 = (UserService) BeanFactory2.createBean("anotherUserService");
        UserService userService2 = (UserService) BeanFactory2.createBean("anotherUserService");
        //此时创建了几个对象
        System.out.println(userService1 == userService2);
    }

    @Test
    public void test07(){
        UserService userService1 = (UserService) BeanFactory3.createBean("anotherUserService");
        UserService userService2 = (UserService) BeanFactory3.createBean("anotherUserService");
        //此时创建了几个对象
        System.out.println(userService1 == userService2);
    }
}
