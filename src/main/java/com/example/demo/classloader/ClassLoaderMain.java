package com.example.demo.classloader;

/**
 * @author: lihui
 * @date: 2020-06-16
 */
public class ClassLoaderMain {
    public static void main(String[] args) {
        System.out.println(ClassLoaderMain.class.getClassLoader());
        ClassLoaderMain[] loaderMains = new ClassLoaderMain[2];
        System.out.println(loaderMains.getClass().getClassLoader());
        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());
        Integer[] integers = new Integer[2];
        System.out.println(integers.getClass().getClassLoader());
        System.out.println(int.class.getClassLoader());
        System.out.println(Integer.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
    }
}
