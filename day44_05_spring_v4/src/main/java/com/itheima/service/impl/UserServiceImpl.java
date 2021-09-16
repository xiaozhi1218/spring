package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

import java.util.Arrays;
import java.util.Map;

/**
 * 包名:com.itheima.service.impl
 * @author Leevi
 * 日期2020-11-10  09:47
 * DI: Dependency Injection 依赖注入，让Spring核心容器给容器中的对象的成员变量赋值
 *     1. 构造函数传参: 前提是有对应的构造函数
 *     2. set方法传参: 前提是要赋值的变量有set方法
 */
public class UserServiceImpl implements UserService{
    //从spring的核心容器中，获取userDao对象，并且赋值给这个成员变量
    private UserDao userDao;
    private String name;
    private String[] strs;
    private Map<String,Object> map;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
        System.out.println(Arrays.toString(strs));
        System.out.println("name的值为:" + name);
        //调用UserDao的实现类的方法添加用户信息
        userDao.addUser();
    }
}
