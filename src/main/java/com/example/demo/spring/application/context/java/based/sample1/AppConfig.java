package com.example.demo.spring.application.context.java.based.sample1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: lihui
 * @date: 2020-06-29
 */
@Configuration
@AllArgsConstructor
@NoArgsConstructor
@Import(AppConfig2.class)
public class AppConfig {

    private MyDao myDao;

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }

    @Bean
    public MyService myService2() {
        return new MyService2(myDao);
    }
}
