package com.example.demo.java.proxy;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author: lihui
 * @date: 2020-06-12
 */
public class SpringProxyStudy {
    interface IInterface {
        void fun1();

        void fun2();
    }

    static class Foo {
        public void fun1() {
            System.out.println("fun1");
            fun2();
        }

        public void fun2() {
            System.out.println("fun2");
        }
    }

    static class Foo2 implements IInterface {
        @Override
        public void fun1() {
            System.out.println("fun1");
            fun2();
        }

        @Override
        public void fun2() {
            System.out.println("fun2");
        }
    }

    static class Before implements MethodBeforeAdvice {
        public void before(Method method, Object[] objects, Object o) throws Throwable {
            System.out.print("before ");
        }
    }

    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new Foo());
        factory.addAdvice(new Before());
        Foo pojo = (Foo) factory.getProxy();
        // this is a method call on the proxy!
        pojo.fun1();

        factory = new ProxyFactory(new Foo2());
        factory.addAdvice(new Before());
        IInterface iInterface = (IInterface) factory.getProxy();
        iInterface.fun1();
    }
}
