package com.example.demo.spring.application.context.sample4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
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
