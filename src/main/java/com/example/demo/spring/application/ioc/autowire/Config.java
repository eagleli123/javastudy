package com.example.demo.spring.application.ioc.autowire;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lihui
 * @date: 2020-07-23
 */
@Configuration
public class Config {
    @Bean
    public JavaBeanOne hello() {
        return new JavaBeanOne();
    }

    @Bean
    @Qualifier("hehe")
    public JavaBeanOne hi() {
        return new JavaBeanOne();
    }

    @Bean
    public JavaBeanOneOne javaBeanOneOne() {
        return new JavaBeanOneOne();
    }

    @Bean
    public JavaBeanTwo javaBeanTwo() {
        return new JavaBeanTwo();
    }
}
