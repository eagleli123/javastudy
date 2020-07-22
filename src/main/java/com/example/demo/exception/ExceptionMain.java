package com.example.demo.exception;

import java.io.IOException;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: lihui
 * @date: 2020-07-16
 */

@NoArgsConstructor
class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}

enum ExceptionType {
    RUNTIME, CUSTOM, IO
}

@Slf4j
class ClassOne {
    public void fun1() {
        log.info("invoked");
        throw new RuntimeException("class one fun1");
    }

    public void fun2() {
        try {
            log.info("invoked");
            throw new RuntimeException("class one fun2");
        } catch (Exception e) {
            log.error("fun2 {}", e.getMessage(), e);
        }
    }

    public void fun3(ExceptionType exceptionType) throws Exception {
        if (ExceptionType.RUNTIME.equals(exceptionType)) {
            throw new RuntimeException("class one fun3");
        } else if (ExceptionType.CUSTOM.equals(exceptionType)) {
            throw new CustomException("class one fun3");
        } else if (ExceptionType.IO.equals(exceptionType)) {
            throw new IOException("class one fun3");
        }
    }
}

@Slf4j
class ClassTwo {
    private ClassOne classOne = new ClassOne();

    public void fun1() {
        log.info("invoked");
        classOne.fun1();
    }
}

@Slf4j
class ClassThree {
    private ClassOne classOne;

    public void fun1() {
        try {
            log.info("invoked");
            classOne.fun1();
        } catch (Exception e) {
            log.error("fun1 {}", e.getMessage(), e);
        }
    }
}

@Slf4j
class ClassFour {
    private ClassOne classOne = new ClassOne();

    public void fun1() {
        log.info("invoked");
        classOne.fun1();
        throw new RuntimeException("class five");
    }
}

@Slf4j
class ClassFive {
    private ClassOne classOne = new ClassOne();

    public void fun2() {
        log.info("before invoked");
        classOne.fun2();
        log.info("after invoked");
    }
}

@Slf4j
class ClassSix {
    private ClassOne classOne = new ClassOne();

    public void fun() {
        try {
            classOne.fun1();
        } catch (Exception e) {
            log.error("fun {}", e.getMessage(), e);
        } finally {
            throw new RuntimeException("---");
        }
    }
}

@Slf4j
class ClassSeven {
    private ClassOne classOne = new ClassOne();

    public void fun(ExceptionType exceptionType) {
        try {
            classOne.fun3(exceptionType);
        } catch (CustomException e) {
            log.error("CustomException fun {}", e.getMessage(), e);
        } catch (IOException e) {
            log.error("IOException fun {}", e.getMessage(), e);
        } catch (Exception e) {
            log.error("Exception fun {}", e.getMessage(), e);
        }
    }
}

public class ExceptionMain {
    public static void main(String[] args) {
        ClassFour classFour = new ClassFour();
        classFour.fun1();

        ClassOne classOne = new ClassOne();
        classOne.fun1();
    }

    @Test
    public void classTwoTest() {
        ClassTwo classTwo = new ClassTwo();
        classTwo.fun1();
    }

    @Test
    public void classThreeTest() {
        ClassThree classThree = new ClassThree();
        classThree.fun1();
    }

    @Test
    public void classFourTest() {
        ClassFour classFour = new ClassFour();
        classFour.fun1();
    }

    @Test
    public void classFiveTest() {
        ClassFive classFive = new ClassFive();
        classFive.fun2();
    }

    @Test
    public void classSixTest() {
        ClassSix classSix = new ClassSix();
        classSix.fun();
    }

    @Test
    public void classSevenTest() {
        ClassSeven classSeven = new ClassSeven();
        classSeven.fun(ExceptionType.RUNTIME);
        classSeven.fun(ExceptionType.CUSTOM);
        classSeven.fun(ExceptionType.IO);
    }
}
