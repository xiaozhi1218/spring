package com.itheima.service.impl;

import com.itheima.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 包名:com.itheima.service.impl
 *
 * @author Leevi
 * 日期2020-11-12  08:35
 * 目标1: 在执行service的所有方法之前加入权限校验
 * 目标2: 在执行完所有的方法之后都获取方法的返回值，并且进行日志打印 "方法执行完毕...，返回值为:", 如果方法出现异常，则不会执行后置通知
 * 目标3: 在执行所有方法出现异常之后,将异常信息写入到本地文件中
 * 目标4: 在执行所有方法之后，无论是否出现异常，均执行 "资源回收的操作......"
 * 目标5: 在执行query()方法的过程中，统计执行时间
 *       环绕通知还能修改切入点方法的返回值
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("执行添加...");
        int number = 10/0;
    }

    @Override
    public void deleteById(int id) {
        //删除了id为
        System.out.println("执行删除..."+id);
    }

    @Override
    public void update() {
        System.out.println("执行修改...");
    }

    @Override
    public String query() {
        try {
            Thread.sleep(3000);
            System.out.println("执行查询...");
            return "张三";
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
