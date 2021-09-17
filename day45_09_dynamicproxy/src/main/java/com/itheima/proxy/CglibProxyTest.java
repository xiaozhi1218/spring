package com.itheima.proxy;

import com.itheima.service.AccountService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 包名:com.itheima.proxy
 *
 * @author Leevi
 * 日期2020-11-11  15:06
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        //使用cglib的动态代理，代理AccountService对象
        AccountService accountService = new AccountService();
        Enhancer enhancer = new Enhancer();

        //设置enhancer的父类
        enhancer.setSuperclass(AccountService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //o 表示代理对象
                // method表示方法
                //objects表示参数
                if (method.getName().equals("save")) {
                    //先进行权限校验
                    System.out.println("校验添加权限。。。");
                    //再调用save()方法
                    method.invoke(accountService,objects);
                    return null;
                }
                //其它方法就不增强
                return method.invoke(accountService,objects);
            }
        });

        //创建代理对象
        AccountService proxyService = (AccountService) enhancer.create();

        proxyService.save();
    }
}
