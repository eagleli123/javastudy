package com.example.demo.spring.application.ioc.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lihui
 * @date: 2020-07-22
 */
@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        ctx.registerShutdownHook();
        Thread.sleep(5000);
        log.info("line ----------------------------- line");
        ctx.start();
        ctx.stop();
        log.info("line ----------------------------- line");
    }
}
