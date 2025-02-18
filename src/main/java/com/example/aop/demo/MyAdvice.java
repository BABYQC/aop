package com.example.aop.demo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author: chang qi
 * @Date: 2025/2/17
 */
public class MyAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Aspect in ...");
        Object retVal = invocation.proceed();
        System.out.println("Aspect out ...");
        return retVal;
    }
}
