package com.example.demo.spring.application.aop.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: lihui
 * @date: 2020-08-07
 */
@Slf4j
@Component
public class NormalBean {

    @RepeatSubmitCheck
    public void send() {
        log.info("send");
    }
}
