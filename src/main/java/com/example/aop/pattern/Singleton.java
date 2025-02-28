package com.example.aop.pattern;

/**
 * @Author: chang qi
 * @Date: 2025/2/28
 */
public class Singleton {
    private Singleton(){ }
    private static final class SingletonHolder {
        public static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
