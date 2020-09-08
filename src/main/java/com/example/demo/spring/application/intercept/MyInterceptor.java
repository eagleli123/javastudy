package com.example.demo.spring.application.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author: lihui
 * @date: 2020-09-02
 */
@Slf4j
public class MyInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("HandlerInterceptorAdapter - request : {}, response : {}", request, response);
        return true;
    }
}
