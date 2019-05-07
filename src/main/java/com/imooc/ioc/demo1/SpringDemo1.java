package com.imooc.ioc.demo1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringDemo1 {

    /**
     * 传统方式
     */
    @Test
    public void demo1() {
        UserService userService = new UserServiceImpl();
        userService.sayHello();
    }

    /**
     * Spring方式
     */
    @Test
    public void demo2() {
        // 创建Spring工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过工厂获得类
        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.sayHello();
    }

    @Test
    public void demo3() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        // 通过工厂获得类
        UserService userService = (UserService) beanFactory.getBean("userService");

        userService.sayHello();
    }
}
