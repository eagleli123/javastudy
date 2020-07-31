package com.example.demo.spring.application.ioc.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author: lihui
 * @date: 2020-07-22 一个简单的bean
 */
@Slf4j
public class NormalBean implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private BeanType beanType;

    public NormalBean() {
        this(BeanType.NORMAL);
    }

    public NormalBean(BeanType beanType) {
        this.beanType = beanType;
    }

    @PostConstruct
    public void postConstruct() {
        log.info("{}, postConstruct", beanType);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("{}, afterPropertiesSet", beanType);
    }

    public void initMethod() {
        log.info("{}, initMethod", beanType);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("{}, preDestroy", beanType);
    }

    @Override
    public void destroy() throws Exception {
        log.info("{}, destroy", beanType);
    }

    public void destroyMethod() {
        log.info("{}, destroyMethod", beanType);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("setApplicationContext, applicationContext : {}", applicationContext);
    }

    @Override
    public void setBeanName(String name) {
        log.info("setBeanName, bean name : {}", name);
    }
}
