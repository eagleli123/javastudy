package com.example.demo.log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lihui
 * @date: 2020-05-29
 */

@Slf4j
public class Slf4jMain {
    @Slf4j
    static class Father {
        void fun() {
            log.info("------");
        }
    }

    @Slf4j
    static class Son extends Father {
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Logger logger = LoggerFactory.getLogger(Object.class);
        logger.trace("=====trace=====");
        logger.debug("=====debug=====");
        logger.info("=====info=====");
        logger.warn("=====warn=====");
        logger.error("=====error=====");
        String str = (Thread.currentThread().hashCode() & Short.MAX_VALUE | 1 << 14)
                + "-" + (System.currentTimeMillis() & Short.MAX_VALUE | 1 << 14)
                + "-" + ((int) (Math.random() * 10_0000) & Short.MAX_VALUE | 1 << 14);
        log.info(str);
        log.info("{}", 8);

        Father father = new Father();
        Son son = new Son();
        father.fun();
        son.fun();
    }
}
