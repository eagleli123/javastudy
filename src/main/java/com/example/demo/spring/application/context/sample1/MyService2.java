package com.example.demo.spring.application.context.sample1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: lihui
 * @date: 2020-06-29
 */
@AllArgsConstructor
public class MyService2 implements MyService {

    @Getter
    private MyDao myDao;

    @Override
    public void hello() {
        System.out.println("hello, 2");
    }

    @Override
    public MyDao getDao() {
        return myDao;
    }
}
