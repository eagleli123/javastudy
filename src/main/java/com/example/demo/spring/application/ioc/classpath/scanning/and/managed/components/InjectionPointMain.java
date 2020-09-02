package com.example.demo.spring.application.ioc.classpath.scanning.and.managed.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author: lihui
 * @date: 2020-07-27
 */
@Component
class FactoryMethodComponent {

    @Bean @Scope("prototype")
    public TestBean prototypeInstance(InjectionPoint injectionPoint) {
        return new TestBean("prototypeInstance for " + injectionPoint.getMember());
    }

    @Bean
    public TestBean testBean(TestBean testBean) {
        return testBean;
    }
}

@Slf4j
public class InjectionPointMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(FactoryMethodComponent.class);
        TestBean testBean = (TestBean) applicationContext.getBean("testBean");
        log.info("testBean : {}", testBean);
    }
}
