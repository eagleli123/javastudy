package com.example.demo.annotation.cglib;

/**
 * @author: lihui
 * @date: 2020-06-28
 */
public class MyAspect {
    public void before() {
        System.out.println("鸡首");
    }

    public void after() {
        System.out.println("牛后");
    }
}