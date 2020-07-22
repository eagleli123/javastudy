package com.example.demo.spring.application.ioc.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author: lihui
 * @date: 2020-07-19
 */
@Configuration
public class ScopesConfig {
    @Bean
    @RequestScope
    public HelloMessageGenerator requestScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @SessionScope
    public HelloMessageGenerator sessionScopedBean() {
        return new HelloMessageGenerator();
    }
}
