package com.example.demo.object;

import java.util.List;

/**
 * @author: lihui
 * @date: 2020-07-17
 */
public class NullObjectMain {
    public static void main(String[] args) {
        if (null instanceof List) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}

