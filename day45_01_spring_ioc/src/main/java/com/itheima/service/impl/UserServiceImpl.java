package com.itheima.service.impl;

import com.itheima.service.UserService;
import org.springframework.stereotype.Component;

/**
 * 包名:com.itheima.service.impl
 * @author Leevi
 * 日期2020-11-10  09:47
 * 注解IOC:
 *    1. 注解写在哪? 要进行IOC的那个类上
 *    2. 用什么注解? Component(用在除了三层结构之外的其他类上)、Controller(用在表现层、控制层的类上)、Service(用在业务层的实现类上)、Repository(用在Dao层的实现类上)
 *    3. 注解有哪些属性? value属性表示对象的id，如果不配置，那么对象的id就默认是类名首字母小写 userServiceImpl
 *    特别容易忘记的点: 一定要在配置文件中配置包扫描
 * 其他注解：
 *    1. @Scope("prototype")，取值如果是singleton就是单例，如果是prototype就是多例
 */
@Component("userService")
public class UserServiceImpl implements UserService{
    @Override
    public void addUser() {
        System.out.println("添加用户...");
    }
}
