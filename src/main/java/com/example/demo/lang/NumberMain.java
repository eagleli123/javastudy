package com.example.demo.lang;

import org.junit.Test;

/**
 * @author: lihui
 * @date: 2020-07-03
 */
public class NumberMain {

    @Test
    public void testLongDoubleConversion() {
        long l1 = Long.MAX_VALUE;
        double d = l1;
        long l2 = (long) d;
        System.out.println(l1 == l2);
    }
}
