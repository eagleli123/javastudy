package com.example.demo.currency;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * @author: lihui
 * @date: 2020-06-01
 */
public class ThreadLocalStudy {

    private static final ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    private static final ThreadLocal<String> threadLocal2 = new ThreadLocal<>();

    private static CountDownLatch countDownLatch1 = new CountDownLatch(2);
    private static CountDownLatch countDownLatch2 = new CountDownLatch(1);

    public static void main(String[] args)
            throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        Thread thread1 = new Thread(() -> {
            threadLocal1.set("thread1-local1");
            threadLocal2.set("thread1-local2");
            countDownLatch1.countDown();
            try {
                countDownLatch2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            threadLocal1.set("thread2-local1");
            threadLocal2.set("thread2-local2");
            countDownLatch1.countDown();
            try {
                countDownLatch2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        countDownLatch1.await();

        System.out.println(threadLocal1 + " " + threadLocal2);
        printThreadLocalMapInfo(thread1);
        printThreadLocalMapInfo(thread2);
        countDownLatch2.countDown();
    }

    /**
     * 输出相关信息
     */
    private static void printThreadLocalMapInfo(Thread thread) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("=====" + thread.getName() + "=====");
        Object threadLocalMapObject = getThreadLocalMapObject(thread);
        System.out.println(threadLocalMapObject);
        List<Object> objects = getEntryList(threadLocalMapObject);
        for (Object object : objects) {
            System.out.println(getEntryKey(object) + " " + getEntryValue(object));
        }
    }

    /**
     * 获取ThreadLocalMap对象
     */
    private static Object getThreadLocalMapObject(Thread thread) throws NoSuchFieldException, IllegalAccessException {
        Field threadLocalsField = Thread.class.getDeclaredField("threadLocals");
        threadLocalsField.setAccessible(true);
        return threadLocalsField.get(thread);
    }

    /**
     * 获取ThreadLocalMap对象中的所有Entry
     */
    private static List<Object> getEntryList(Object threadLocalMapObject)
            throws NoSuchFieldException, IllegalAccessException {
        Field tableField = threadLocalMapObject.getClass().getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] objects = (Object[]) tableField.get(threadLocalMapObject);
        return Arrays.stream(objects).filter((obj) -> {
            return obj != null;
        }).collect(Collectors.toList());
    }

    /**
     * 获取Entry的key
     */
    private static Object getEntryKey(Object entry) throws NoSuchFieldException, IllegalAccessException {
        Field referentField = entry.getClass().getSuperclass().getSuperclass().getDeclaredField("referent");
        referentField.setAccessible(true);
        return referentField.get(entry);
    }

    /**
     * 获取Entry的value
     */
    private static Object getEntryValue(Object entry) throws NoSuchFieldException, IllegalAccessException {
        Field valueField = entry.getClass().getDeclaredField("value");
        valueField.setAccessible(true);
        return valueField.get(entry);
    }
}
