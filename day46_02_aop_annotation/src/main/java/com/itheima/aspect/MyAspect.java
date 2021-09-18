package com.itheima.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 包名:com.itheima.aspect
 * @author Leevi
 * 日期2020-11-12  08:37
 * 1. 在spring的配置文件中开启AOP的自动代理  <aop:aspectj-autoproxy />
 * 2. 在作为切面的类上添加Aspect注解
 * 3. 在切面中声明切入点: 创建一个public void方法，方法名就是切入点的id，方法上添加Pointcut注解用于编写切入点表达式
 * 4. 配置通知，在要作为通知的方法上添加注解:
 *    1. Before 前置通知
 *    2. AfterReturning 后置通知
 *    3. After 最终通知
 *    4. AfterThrowing 异常通知
 *    5. Around 环绕通知
 */
@Component
@Aspect
public class MyAspect {
    @Pointcut("execution(* com.itheima.service.impl.UserServiceImpl.*(..))")
    public void pt1(){

    }
    @Pointcut("execution(String com.itheima.service.impl.UserServiceImpl.query())")
    public void pt2(){

    }

    @Before("pt1()")
    public void checkPermission(){
        System.out.println("进行权限校验....");
    }

    @AfterReturning(value = "pt2()",returning = "returnValue")
    public void printResult(String returnValue){
        //1. 获取被增强方法的返回值,就是returnValue
        //2. 打印
        System.out.println("执行完毕，方法的返回值为:"+returnValue);
    }

    @AfterThrowing(value = "pt1()",throwing = "errorMsg")
    public void printError(Throwable errorMsg){
        errorMsg.printStackTrace();
        //使用流将字符串(异常信息)，写入到本地磁盘文件中
        System.out.println("使用FileOutputStream将" + errorMsg.getStackTrace() + "写入到磁盘...");
    }

    @After("pt1()")
    public void close(){
        System.out.println("执行资源回收的操作...");
    }

    @Around("pt2()")
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
