package com.example.demo.spring.application.context.java.based.sample6;

import lombok.Getter;

/**
 * @author: lihui
 * @date: 2020-07-08
 */
@Getter
public class MyService6 {
    private MyDao1 myDao1;
    private MyDao2 myDao2;

    //@Autowired(required = false)
    //public MyService6() {
    //}
    //
    //@Autowired(required = false)
    //public MyService6(MyDao1 myDao1) {
    //    this.myDao1 = myDao1;
    //}
    //
    //@Autowired(required = false)
    //public MyService6(MyDao2 myDao2) {
    //    this.myDao2 = myDao2;
    //}

    //@Autowired(required = false)
    //public MyService6(MyDao3 myDao3) {
    //}
    //
    //@Autowired(required = false)
    //public MyService6(MyDao4 myDao4) {
    //}

    // @Autowired(required = false)
    public MyService6(MyDao1 myDao1, MyDao2 myDao2) {
        this.myDao1 = myDao1;
        this.myDao2 = myDao2;
    }
}
