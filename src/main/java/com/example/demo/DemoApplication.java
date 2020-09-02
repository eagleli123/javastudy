package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
@ComponentScan("com.example.demo.vue")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);
        //NormalBean normalBean = context.getBean(NormalBean.class);
        //normalBean.send();
    }
}
