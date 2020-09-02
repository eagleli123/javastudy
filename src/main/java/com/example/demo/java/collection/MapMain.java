package com.example.demo.java.collection;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 * @author: lihui
 * @date: 2020-08-12
 */
public class MapMain {
    public static void main(String[] args) {
        Map<String, String> hello = Maps.newHashMap();
        hello.put("hello", "hello");
        System.out.println(hello.get("hello"));
        System.out.println(hello.computeIfAbsent("hello", k -> "---"));
        System.out.println(hello.computeIfAbsent("he", k -> k));
        System.out.println(hello.computeIfAbsent("he2", k -> "-0-"));
    }
}
