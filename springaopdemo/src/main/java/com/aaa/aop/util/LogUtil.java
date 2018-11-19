package com.aaa.aop.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.Pointcut;

/**
 * className:LogUtil
 * discriptoin:通知类 是切面（日志记录功能）的具体实现类
 * author:fy
 * createTime:2018-11-08 14:07
 */
public class LogUtil {
    /**
     * 记录日志功能
     */
    public  void saveLog(){

        System.out.println("模拟日志记录");
    }

    /**
     * 前置通知
     */
    public  void beforeAdvice(JoinPoint joinPoint){
        //获取连接点方法名称
        String name = joinPoint.getSignature().getName();
        System.out.println("执行业务方法"+name+"执行业务方法之前执行的操作...");
    }

    /**
     * 异常通知
     * @param joinPoint
     * @param ex
     */
    public  void exceptionAdvice(JoinPoint joinPoint,Exception ex){
        //获取连接点方法名称
        String name=joinPoint.getSignature().getName();
        System.out.println("执行业务方法"+name+"时候，发生名称为"+ex.getClass().getName()+"的异常，异常描述为："+ex.getMessage());
    }

    /**
     * 最终通知
     * @param joinPoint
     */
    public  void fianlAdvice(JoinPoint joinPoint){
        System.out.println("无论连接点方法执行过程中有没有异常，都会执行。。。。。。。。。");
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return
     */
    public  Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println(System.currentTimeMillis()+"在业务方法执行之前操作");
        Object o=null;
        //调用业务方法
        try {
           o=proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()+"在业务方法执行之后操作");
        return o;
    }
}
