package com.example.demo.spring.application.context.sample7;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lihui
 * @date: 2020-06-30
 */
@Configuration
public class AppConfig {

    @Bean
    public MyService myService(MyDao myDao) {
        return new MyService(myDao);
    }

    @Bean
    public MyDao myDao() {
        return new MyDao();
    }
}
