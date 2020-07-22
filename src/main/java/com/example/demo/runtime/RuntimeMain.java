package com.example.demo.runtime;

import java.io.IOException;

/**
 * @author: lihui
 * @date: 2020-07-17
 */
public class RuntimeMain {
    public static void main(String[] args) throws IOException {
        // 仅适用 mac os
        Runtime.getRuntime().exec("open -a Calculator ");
    }
}
