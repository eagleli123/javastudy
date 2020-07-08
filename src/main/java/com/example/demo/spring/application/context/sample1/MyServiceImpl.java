package com.example.demo.spring.application.context.sample1;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: lihui
 * @date: 2020-06-29
 */
public class MyServiceImpl implements MyService {
    @Autowired
    private MyDao myDao;

    @Override
    public void hello() {
        System.out.println("hello, world");
    }

    @Override
    public MyDao getDao() {
        return myDao;
    }
}
