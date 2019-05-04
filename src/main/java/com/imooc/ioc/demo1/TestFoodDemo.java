package com.imooc.ioc.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFoodDemo {

    @Test
    public void testFood() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Food food = (Food) applicationContext.getBean("food");
        System.out.print(food.toString());
    }
}
