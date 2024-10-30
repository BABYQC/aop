package com.example.aop.demo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.PointcutAdvisor;

/**
 * @author chang qi
 * @date 2024/10/29
 */
public class AgentDecorator implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("James");
        Object result = invocation.proceed();
        System.out.println("!!!");
        return result;
    }
}
