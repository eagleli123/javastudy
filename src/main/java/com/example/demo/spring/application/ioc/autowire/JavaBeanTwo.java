package com.example.demo.spring.application.ioc.autowire;

import javax.annotation.Resource;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;

/**
 * @author: lihui
 * @date: 2020-07-23
 */
@Data
public class JavaBeanTwo {

    @Autowired(required = false)
    @Qualifier("hehe")
    private JavaBeanOne hello;

    @Autowired(required = false)
    private JavaBeanOne hi;

    @Resource(name = "hi")
    private JavaBeanOne javaBeanOne;

    @Resource
    private JavaBeanOneOne hehe;
}
