package com.aaa.aop.util.test;

import com.aaa.aop.service.DeptServiceImpl;
import com.aaa.aop.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * className:AopTest
 * discriptoin:
 * author:fy
 * createTime:2018-11-08 14:36
 */
public class AopTest {
    public static void main(String[] args) {
        //使用spring提供的配置文件加载类，加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springaop-config.xml");
        //使用BeanFactory接口中提供的getBean方法获取对象
        DeptServiceImpl deptService = (DeptServiceImpl) applicationContext.getBean("deptService");
        deptService.add();
        //使用BeanFactory接口中提供的getBean方法获取对象
        UserServiceImpl userService=(UserServiceImpl) applicationContext.getBean("userService");
        userService.delete();
        userService.add();
    }
}
