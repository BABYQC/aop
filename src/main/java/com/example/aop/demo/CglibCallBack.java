package com.example.aop.demo;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chang qi
 * @date 2025/3/1
 */
public class CglibCallBack implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.printf("【CGLIB 代理】方法%s调用前：%n", method.getName());
        Object result = proxy.invokeSuper(obj, args);
        System.out.printf("【CGLIB 代理】方法%s调用前：%n", method.getName());
        return result;
    }
}
