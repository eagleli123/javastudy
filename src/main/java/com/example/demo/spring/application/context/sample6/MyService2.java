package com.example.demo.spring.application.context.sample6;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lihui
 * @date: 2020-07-08
 */
@Getter
public class MyService2 {
    private MyDao1 myDao1;
    private MyDao2 myDao2;

    @Autowired
    public void setMyDao1(MyDao1 myDao1) {
        this.myDao1 = myDao1;
    }

    @Autowired
    public void fun(MyDao2 myDao2) {
        this.myDao2 = myDao2;
    }
}
