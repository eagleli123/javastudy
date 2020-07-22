package com.example.demo.dubbo.demo.provider;

import com.example.demo.dubbo.demo.DemoService;

/**
 * @author: lihui
 * @date: 2020-07-11
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
