package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
@ComponentScan("com.example.demo.spring.boot.externalized.configuration")
@PropertySource("classpath:config.properties")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println(System.getenv());
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);
        //NormalBean normalBean = context.getBean(NormalBean.class);
        //normalBean.send();
    }
}
