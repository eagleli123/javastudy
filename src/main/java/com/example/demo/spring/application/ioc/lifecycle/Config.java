package com.example.demo.spring.application.ioc.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lihui
 * @date: 2020-07-22
 */
@Configuration
@Slf4j
public class Config {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public NormalBean normalBean() {
        return new NormalBean();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public LifecycleBean lifecycleBean() {
        return new LifecycleBean();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public SmartLifecycle smartLifecycle() {
        return new SmartLifecycleBean();
    }

    @Bean
    public static MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
        return new MyBeanFactoryPostProcessor();
    }

    @Bean
    public static MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }
}
