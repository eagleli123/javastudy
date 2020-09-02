package com.example.demo.java.annotation.cglib;

import com.example.demo.java.annotation.SensitiveInfo;
import com.example.demo.java.annotation.SensitiveType;

/**
 * @author: lihui
 * @date: 2020-06-28
 */
public class UserServiceImpl {

    public void addUser(String hello, @SensitiveInfo(type = SensitiveType.TOKEN) String token) {
        System.out.println("add User");
    }

    public void updateUser() {
        System.out.println("update User");
    }

    public void deleteUser() {
        System.out.println("delete User");
    }
}

