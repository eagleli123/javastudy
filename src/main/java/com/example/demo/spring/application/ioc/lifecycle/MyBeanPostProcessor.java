package com.example.demo.spring.application.ioc.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: lihui
 * @date: 2020-07-25
 */
@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessBeforeInitialization, bean:{}", beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessAfterInitialization, bean:{}", beanName);
        return bean;
    }
}
