package com.imooc.ioc.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo3 {

    @Test
    public void demo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person1 = (Person) ctx.getBean("person");
        Person person2 = (Person) ctx.getBean("person");

        System.out.println(person1);
        System.out.println(person2);
    }

    @Test
    public void demo2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Man man = (Man) context.getBean("man");

        System.out.println(man);
        context.close();
    }

    @Test
    public void demo3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Man man1 = (Man) context.getBean("man");
        System.out.println(man1);
        man1.run();
        context.close();
    }

    @Test
    public void demo4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao user = (UserDao) context.getBean("userDao");
        user.findAll();
        user.delete();
        user.save();
        user.update();
    }
}
