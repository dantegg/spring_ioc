package com.imooc.ioc.demo6;

import com.imooc.ioc.demo5.CollectionBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo6 {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService bean = (ProductService) context.getBean("productService");
        bean.save();
    }
}
