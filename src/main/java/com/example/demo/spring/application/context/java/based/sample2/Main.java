package com.example.demo.spring.application.context.java.based.sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lihui
 * @date: 2020-06-29
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        System.out.println(ctx.getBean(DataSource.class));
        System.out.println(ctx.getBean(RepositoryOne.class).getDataSource());
        System.out.println(ctx.getBean(RepositoryTwo.class).getDataSource());
        System.out.println(ctx.getBean(RepositoryThree.class).getDataSource());

        System.out.println(ctx.getBean(Config.class));
    }
}
