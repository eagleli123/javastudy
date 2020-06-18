package com.example.demo.java.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: lihui
 * @date: 2020-05-22
 */
public class InheritedAnnotationStudy {
    public static void main(String[] args) {
        InheritedAnnotation inheritedAnnotation =
                ClassInAnnotationParentOne.class.getAnnotation(InheritedAnnotation.class);
        System.out.println(inheritedAnnotation.value());
        inheritedAnnotation = ClassInAnnotationChildOne.class.getAnnotation(InheritedAnnotation.class);
        System.out.println(inheritedAnnotation.value());

        NotInheritedAnnotation notInheritedAnnotation = ClassInAnnotationParentTwo.class.getAnnotation(
                NotInheritedAnnotation.class);
        System.out.println(notInheritedAnnotation.value());
        notInheritedAnnotation = ClassInAnnotationChildTwo.class.getAnnotation(NotInheritedAnnotation.class);
        System.out.println(notInheritedAnnotation == null);
    }
}

@InheritedAnnotation("123")
class ClassInAnnotationParentOne {
}

class ClassInAnnotationChildOne extends ClassInAnnotationParentOne {
}

@NotInheritedAnnotation("456")
class ClassInAnnotationParentTwo {
}

class ClassInAnnotationChildTwo extends ClassInAnnotationParentTwo {
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited @interface InheritedAnnotation {
    String value() default "value";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented @interface NotInheritedAnnotation {
    String value() default "value";
}