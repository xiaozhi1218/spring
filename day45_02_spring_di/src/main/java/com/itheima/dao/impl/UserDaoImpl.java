package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * 包名:com.itheima.dao.impl
 *
 * @author Leevi
 * 日期2020-11-11  09:10
 * 对UserDaoImpl进行IOC
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void addUser() {
        System.out.println("执行数据库的SQL语句对用户进行添加...");
    }
}
