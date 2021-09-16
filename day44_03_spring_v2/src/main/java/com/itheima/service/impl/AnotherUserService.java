package com.itheima.service.impl;

import com.itheima.service.UserService;

/**
 * 包名:com.itheima.service.impl
 *
 * @author Leevi
 * 日期2020-11-10  10:02
 */
public class AnotherUserService implements UserService {
    public void initData(){
        System.out.println("执行对象创建时候的一些数据初始化工作...");
    }

    public void saveData(){

        System.out.println("执行对象销毁之前的数据备份...");
    }
    @Override
    public void addUser() {
        System.out.println("另外一个实现类添加用户");
    }
}
