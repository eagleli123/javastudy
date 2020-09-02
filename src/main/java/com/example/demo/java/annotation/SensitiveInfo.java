package com.example.demo.java.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented // 注解包含于Javadoc中
@Target({ElementType.FIELD, ElementType.PARAMETER}) // 指定注解类型,属性上添加注解
@Retention(RetentionPolicy.RUNTIME) // 指定注解策略
public @interface SensitiveInfo {
    SensitiveType type();//使用枚举指定注解类型
}
