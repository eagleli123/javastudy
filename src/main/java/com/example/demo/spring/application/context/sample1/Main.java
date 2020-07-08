package com.example.demo.spring.application.context.sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lihui
 * @date: 2020-06-29
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService = (MyService) ctx.getBean("myService");
        MyService myService2 = (MyService) ctx.getBean("myService2");
        myService.hello();
        MyDao myDao = ctx.getBean(MyDao.class);
        System.out.println(myDao);
        System.out.println(myService.getDao());
        System.out.println(myService2.getDao());
    }
}
