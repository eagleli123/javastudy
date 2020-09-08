package com.example.demo.spring.application.intercept;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lihui
 * @date: 2020-09-02
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String get(HttpServletRequest request, String name, @AddHello String hello) {
        return hello;
    }
}
