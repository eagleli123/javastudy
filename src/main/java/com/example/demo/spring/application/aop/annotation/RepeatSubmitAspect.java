package com.example.demo.spring.application.aop.annotation;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class RepeatSubmitAspect {

    //@Pointcut("@annotation(com.example.demo.spring.application.aop.annotation.RepeatSubmitCheck)")
    //public void requestPointcut() {
    //}

    @Before("@annotation(repeatSubmitCheck)")
    public void aroundCheck(JoinPoint joinPoint, RepeatSubmitCheck repeatSubmitCheck) {
        log.info("aroundCheck");
        String className = joinPoint.getTarget().getClass().getName();

        String methodName = joinPoint.getSignature().getName();

        Object[] args = joinPoint.getArgs();
        String paramsJsonStr = JSON.toJSONString(args);

        String srcStr = className + "_" + methodName + "_" + paramsJsonStr;
        log.info(srcStr);
    }
}