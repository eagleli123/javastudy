package com.example.demo.property;

import java.io.File;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author: lihui
 * @date: 2020-06-16
 */
public class PropertyMain {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        // properties.forEach((key, value) -> System.out.println(key + "=" + value));

        URL url = PropertyMain.class.getClassLoader().getResource("logback.xml");
        System.out.println(url);
        url = PropertyMain.class.getResource("logback.xml");
        System.out.println(url);
    }
}
