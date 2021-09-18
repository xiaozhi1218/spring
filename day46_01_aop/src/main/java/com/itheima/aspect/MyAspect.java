package com.itheima.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * 包名:com.itheima.aspect
 * @author Leevi
 * 日期2020-11-12  08:37
 */
@Component
public class MyAspect {
    public void checkPermission(){
        System.out.println("进行权限校验....");
    }

    public void printResult(String returnValue){
        //1. 获取被增强方法的返回值,就是returnValue
        //2. 打印
        System.out.println("执行完毕，方法的返回值为:"+returnValue);
    }

    public void printError(Throwable errorMsg){
        errorMsg.printStackTrace();
        //使用流将字符串(异常信息)，写入到本地磁盘文件中
        System.out.println("使用FileOutputStream将" + errorMsg.getStackTrace() + "写入到磁盘...");
    }

    public void close(){
        System.out.println("执行资源回收的操作...");
    }

    public Object totalTime(ProceedingJoinPoint joinPoint){
        try {
            //1. 获取当前时间
            long startTime = System.currentTimeMillis();
            //2. 执行切入点
            Object obj = joinPoint.proceed();
            //3. 获取执行完切入点之后的时间
            long endTime = System.currentTimeMillis();
            System.out.println("方法的总执行时间是:" + (endTime - startTime));
            return "hello:"+obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new RuntimeException(throwable.getMessage());
        }
    }
}
