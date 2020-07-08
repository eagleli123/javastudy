package com.example.demo.method;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Set;
import javafx.util.Pair;

/**
 * @author: lihui
 * @date: 2020-07-08
 */
public class MultipleParam {

    public static void main(String[] args) {
        Set<String> strings = Sets.newHashSet("123", "456");
        Object[] objects = new String[5];
        test(strings);
    }

    public static void test(Object... keys) {
        System.out.println(Arrays.toString(keys));
        System.out.println(keys.length);
    }
}
