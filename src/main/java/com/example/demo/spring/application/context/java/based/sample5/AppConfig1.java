package com.example.demo.spring.application.context.java.based.sample5;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: lihui
 * @date: 2020-07-05
 */
public class AppConfig1 {
    @Getter
    // @Autowired
    @Autowired(required = false)
    private App app;
}
