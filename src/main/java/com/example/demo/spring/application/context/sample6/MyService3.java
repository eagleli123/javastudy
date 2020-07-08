package com.example.demo.spring.application.context.sample6;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lihui
 * @date: 2020-07-08
 */
@Getter
public class MyService3 {
    @Autowired
    private MyDao1 myDao1;
}
