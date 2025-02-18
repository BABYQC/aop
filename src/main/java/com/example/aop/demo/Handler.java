package com.example.aop.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: chang qi
 * @Date: 2025/2/10
 */
public class Handler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("handler invoke");
        Object result = method.invoke(args);
        return result;
    }
}
