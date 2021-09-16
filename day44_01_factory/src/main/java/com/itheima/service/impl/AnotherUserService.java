package com.itheima.service.impl;

import com.itheima.service.UserService;

/**
 * 包名:com.itheima.service.impl
 *
 * @author Leevi
 * 日期2020-11-10  10:02
 */
public class AnotherUserService implements UserService {
    @Override
    public void addUser() {
        System.out.println("另外一个实现类添加用户");
    }
}
