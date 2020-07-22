package com.example.demo.spring.application.context.java.based.sample7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lihui
 * @date: 2020-06-30
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService = applicationContext.getBean(MyService.class);
        MyDao myDao = applicationContext.getBean(MyDao.class);
        System.out.println(myService.getMyDao() == myDao);
    }
}
