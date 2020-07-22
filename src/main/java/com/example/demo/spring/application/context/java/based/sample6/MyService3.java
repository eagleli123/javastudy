package com.example.demo.spring.application.context.java.based.sample6;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: lihui
 * @date: 2020-07-08
 */
@Getter
public class MyService3 {
    @Autowired
    private MyDao1 myDao1;
}
