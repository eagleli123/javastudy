package com.example.demo.java.classes;

/**
 * @author: lihui
 * @date: 2020-06-18
 */
public class FieldMain {
    static class Father {
        String string;
    }

    static class Son extends Father {
        Integer integer;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Son son = new Son();
        son.string = "string";
        son.integer = 1;
        Father father = son;
        System.out.println(father.getClass().getDeclaredField("integer").get(father));
    }
}
