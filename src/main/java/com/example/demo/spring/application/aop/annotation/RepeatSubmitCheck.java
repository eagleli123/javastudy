package com.example.demo.spring.application.aop.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmitCheck {
    int keepSeconds() default 1;
}