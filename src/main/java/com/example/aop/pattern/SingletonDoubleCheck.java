package com.example.aop.pattern;

/**
 * @Author: chang qi
 * @Date: 2025/2/28
 */
public class SingletonDoubleCheck {

    private static SingletonDoubleCheck INSTANCE = null;
    private SingletonDoubleCheck() { }

    public SingletonDoubleCheck getInstance() {
        if (INSTANCE == null) {
            synchronized (this) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDoubleCheck();
                }
            }
        }
        return INSTANCE;
    }
}
