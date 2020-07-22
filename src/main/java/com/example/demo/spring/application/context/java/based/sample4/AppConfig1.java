package com.example.demo.spring.application.context.java.based.sample4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * @author: lihui
 * @date: 2020-07-05
 */
@Component
@AllArgsConstructor
public class AppConfig1 {
    @Getter
    private App app;
}
