package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * 包名:com.itheima.dao.impl
 *
 * @author Leevi
 * 日期2020-11-11  09:19
 */
@Repository
public class AnotherUserDaoImpl implements UserDao {

    @Override
    public void addUser() {
        System.out.println("AnotherUserDaoImpl执行add.....");
    }
}
