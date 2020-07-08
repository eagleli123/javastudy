package com.example.demo.java.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * @author: lihui
 * @date: 2020-05-20
 */
public class CompositeAnnotationStudy {
    public static void main(String[] args) {
        AnnotationTwo annotationTwo = ClassInAnnotation.class.getAnnotation(AnnotationTwo.class);
        System.out.println(annotationTwo.basePackages());
        AnnotationOne annotationOne = annotationTwo.annotationType().getAnnotation(AnnotationOne.class);
        System.out.println(annotationOne.value());

        System.out.println(annotationTwo.getClass().getAnnotation(AnnotationOne.class));
    }
}

@AnnotationTwo()
class ClassInAnnotation {
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AnnotationOne
@interface AnnotationTwo {
    String basePackages() default "basePackages";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface AnnotationOne {
    String value() default "value";
}


