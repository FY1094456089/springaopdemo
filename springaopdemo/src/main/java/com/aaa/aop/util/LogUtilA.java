package com.aaa.aop.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * className:LogUtil
 * discriptoin:通知类 是切面（日志记录功能）的具体实现类
 * author:fy
 * createTime:2018-11-08 14:07
 */
@Component //三个分层之外，用该注解
@Aspect//通知类的注解
public class LogUtilA {
    @Pointcut(value ="execution(void add*(..))")
    public  void pointa(){

    }
    /**
     * 记录日志功能
     */
    @AfterReturning(value = "pointa()")
    public  void saveLog(){

        System.out.println("模拟日志记录123");
    }

    /**
     * 前置通知
     */
   // @Before(value = "pointa()")
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
   // @AfterThrowing(value = "pointa()",throwing ="ex")
    public  void exceptionAdvice(JoinPoint joinPoint,Exception ex){
        //获取连接点方法名称
        String name=joinPoint.getSignature().getName();
        System.out.println("执行业务方法11111"+name+"时候，发生名称为"+ex.getClass().getName()+"的异常，异常描述为："+ex.getMessage());
    }

    /**
     * 最终通知
     * @param joinPoint
     */
   // @After(value = "pointa()")
    public  void fianlAdvice(JoinPoint joinPoint){
        System.out.println("无论连接点方法执行过程中有没有异常，都会执行。。。。。。。。。");

    }
 /*Vector v =new Vector();
    for(int i=0;i<vector.size();i++){
        Object object=vector.get(i);
        if(!v.contains(object));
        v.add(object);
    }*/


}
