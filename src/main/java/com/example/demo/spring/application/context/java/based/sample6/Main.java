package com.example.demo.spring.application.context.java.based.sample6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lihui
 * @date: 2020-07-08
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(
                        MyService1.class,
                        MyService2.class,
                        MyService3.class,
                        MyService4.class,
                        MyService5.class,
                        MyService6.class,
                        MyDao1.class,
                        MyDao2.class,
                        MyDao3.class,
                        MyDao4.class);

        MyService1 myService1 = annotationConfigApplicationContext.getBean(MyService1.class);
        System.out.println(myService1.getMyDao1());

        MyService2 myService2 = annotationConfigApplicationContext.getBean(MyService2.class);
        System.out.println(myService2.getMyDao1());
        System.out.println(myService2.getMyDao2());

        MyService3 myService3 = annotationConfigApplicationContext.getBean(MyService3.class);
        System.out.println(myService3.getMyDao1());

        MyService4 myService4 = annotationConfigApplicationContext.getBean(MyService4.class);
        System.out.println(myService4.getMyDao1());
        System.out.println(myService4.getMyDao2());
        System.out.println(myService4.getMyDao3());

        MyService5 myService5 = annotationConfigApplicationContext.getBean(MyService5.class);
        System.out.println(myService5.getMyDao1());

        MyService6 myService6 = annotationConfigApplicationContext.getBean(MyService6.class);
        System.out.println(myService6.getMyDao1());
        System.out.println(myService6.getMyDao2());

        System.out.println("------");
        System.out.println(annotationConfigApplicationContext.getBean(MyDao1.class));
        System.out.println(annotationConfigApplicationContext.getBean(MyDao2.class));
        System.out.println(annotationConfigApplicationContext.getBean(MyDao3.class));
    }
}
