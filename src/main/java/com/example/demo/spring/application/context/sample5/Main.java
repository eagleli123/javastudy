package com.example.demo.spring.application.context.sample5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lihui
 * @date: 2020-07-05
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig1.class, AppConfig2.class);
        AppConfig1 config1 = applicationContext.getBean(AppConfig1.class);
        // App app = applicationContext.getBean(App.class);
        // System.out.println(app);
        System.out.println(config1.getApp());
    }
}
