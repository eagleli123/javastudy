package com.example.demo.spring.application.context.sample5;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
