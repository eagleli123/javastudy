package com.example.demo.spring.application.context.sample6;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: lihui
 * @date: 2020-07-08
 */
@Getter
public class MyService4 {
    @Autowired
    private MyDao1 myDao1;
    private MyDao2 myDao2;
    private MyDao3 myDao3;

    @Autowired
    public void fun(MyDao2 myDao2) {
        this.myDao2 = myDao2;
        System.out.println("12345");
    }

    @Autowired
    public MyService4(MyDao3 myDao3) {
        this.myDao3 = myDao3;
    }
}
