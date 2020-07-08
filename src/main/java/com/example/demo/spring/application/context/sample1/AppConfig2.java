package com.example.demo.spring.application.context.sample1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lihui
 * @date: 2020-07-05
 */
@Configuration
public class AppConfig2 {
    @Bean
    public MyDao myDao() {
        return new MyDao();
    }
}
