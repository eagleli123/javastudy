package com.example.demo.java.currency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;

/**
 * @author: lihui
 * @date: 2020-08-25
 */
public class LockStudy {

    @Test
    public void lock() throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lock();

        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }, "child thread -1");

        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(1000000);
    }

    @Test
    public void lockInterruptibly() throws InterruptedException {
        final Lock lock = new ReentrantLock();
        lock.lock();

        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        }, "child thread -1");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(1000000);
    }

    @Test
    public void lockInterruptibly2() throws InterruptedException {
        final Lock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                System.out.println("hei hei");
                while (true) {
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        }, "child thread -1");
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
        System.out.println("t1.interrupt()");
        lock.lock();
        System.out.println("lock");
        lock.unlock();
        Thread.sleep(1000000);
    }
}
