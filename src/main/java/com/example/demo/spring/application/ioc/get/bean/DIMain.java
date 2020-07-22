package com.example.demo.spring.application.ioc.get.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author: lihui
 * @date: 2020-07-14
 */

@Data
class Father {
    private String name = "father";
}

@Data
class Son extends Father {
    private String name = "son";
}

@Service
@Data
class Component {
    @Autowired
    private Father father;

    @Autowired
    private Son son;
}

public class DIMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Father.class, Son.class, Component.class);
        System.out.println(context.getBean(Component.class));
        System.out.println(context.getBean("son"));
        System.out.println(context.getBean("father"));
        System.out.println(context.getBean(Son.class));
        // System.out.println(context.getBean(Father.class));
    }
}
