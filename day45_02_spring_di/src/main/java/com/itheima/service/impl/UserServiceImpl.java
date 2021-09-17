package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 包名:com.itheima.service.impl
 * @author Leevi
 * 日期2020-11-10  09:47
 * 注解方式的依赖注入:
 *      1. 注解用在哪? 用在要进行依赖注入的成员变量上
 *      2. 使用哪个注解?
 *         2.1 注入简单类型的数据，使用Value注解
 *         2.2 注入对象类型的数据，使用Autowired注解,它会根据类型进行注入
 *             如果spring的核心容器中，只有一个该类型的对象，那么就不用指定id，会直接将那个对象注入进来
 *             如果spring的核心容器中，有多个同类型的对象,那么此时只根据类型就无法自动注入了，就需要根据变量名
 *             进行匹配，匹配对象的id；如果属性名和对象的id无法进行匹配，那么就得自己手动指定要匹配哪个对象的id，
 *             就用Qualifier注解
 *        2.3 注入对象类型的数据，使用Resource注解，它既可以根据类型注入，也可以根据id注入
 *            如果spring的核心容器中，只有一个该类型的对象，那么就不用指定id，会直接将那个对象注入进来
 *            如果spring的核心容器中，有多个同类型的对象,那么此时只根据类型就无法自动注入了，就需要根据变量名
 *            进行匹配，匹配对象的id；
 *            如果属性名和对象的id无法进行匹配，那么就得自己手动指定要匹配哪个对象的id
 */
@Component("userService")
public class UserServiceImpl implements UserService{
    //@Autowired
    //@Qualifier("anotherUserDaoImpl")
    @Resource(name="userDaoImpl")
    private UserDao userDao;

    @Value("张三疯")
    private String name;

    @Override
    public void addUser() {
        System.out.println(name);
        userDao.addUser();
    }
}
