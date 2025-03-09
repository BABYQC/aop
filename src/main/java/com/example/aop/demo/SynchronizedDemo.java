package com.example.aop.demo;

/**
 * @author chang qi
 * @date 2025/3/6
 */
public class SynchronizedDemo {
    public synchronized static void staticMethod() { }

    public void syncClass() {
        synchronized (SynchronizedDemo.class) {

        }
    }

    public synchronized void method() { }

    public void demo() {
        synchronized (this) {

        }
        Object lock = new Object();
        synchronized (lock) {

        }
    }

}
