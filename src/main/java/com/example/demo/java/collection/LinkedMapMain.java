package com.example.demo.java.collection;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 * @author: lihui
 * @date: 2020-06-18
 */
public class LinkedMapMain {
    public static void main(String[] args) {
        Map<String, String> map = Maps.newLinkedHashMap();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        System.out.println(map.keySet());
        System.out.println(map.values());
    }
}
