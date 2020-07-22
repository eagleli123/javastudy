package com.example.demo.spring.application.context.java.based.sample3;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lihui
 * @date: 2020-06-30
 */
@Service
public class MyService {

    @Autowired
    public MyService(MyDao myDao) {
        this.myDao = myDao;
    }

    @Autowired
    public void fun(MyDao myDao) {
        this.myDao = myDao;
    }

    @Autowired
    @Getter
    private MyDao myDao;
}
