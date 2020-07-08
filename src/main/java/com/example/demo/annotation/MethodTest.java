package com.example.demo.annotation;

/**
 * @author: lihui
 * @date: 2020-06-28
 */
public class MethodTest {

    public void fun1(@SensitiveInfo(type = SensitiveType.TOKEN) String token) {
        System.out.println(token);
    }
}
