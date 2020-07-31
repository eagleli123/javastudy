package com.example.demo.spring.application.ioc.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.SmartLifecycle;

/**
 * @author: lihui
 * @date: 2020-07-22
 * 实现了SmartLifecycle的一个bean
 */
@Slf4j
public class SmartLifecycleBean extends NormalBean implements SmartLifecycle {
    private volatile boolean running = false;

    public SmartLifecycleBean() {
        super(BeanType.SMART_LIFECYCLE);
    }

    @Override
    public void start() {
        log.info("start");
        running = true;
    }

    @Override
    public void stop() {
        log.info("stop");
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
