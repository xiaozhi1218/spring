package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

/**
 * 包名:com.itheima.dao.impl
 *
 * @author Leevi
 * 日期2020-11-10  14:33
 * 采用p命名空间进行依赖注入
 */
public class UserDaoImpl implements UserDao {
    private Integer age;

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void addUser() {
        System.out.println("执行sql语句将用户信息添加到数据库...."+age);
    }
}
