package com.example.demo.spring.application.ioc.autowire;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lihui
 * @date: 2020-07-23
 */
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        JavaBeanTwo bean = context.getBean(JavaBeanTwo.class);
        System.out.println(bean);
    }
}
