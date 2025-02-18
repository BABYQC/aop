package com.example.aop.demo;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author chang qi
 * @date 2024/10/29
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        IFoo foo = new FooImpl();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(foo);
        proxyFactory.setInterfaces(IFoo.class);
        proxyFactory.addAdvice(new MyAdvice());
        proxyFactory.setProxyTargetClass(false);
        IFoo proxiedFoo = (IFoo) proxyFactory.getProxy();
        proxiedFoo.doSomething();
        Thread.sleep(60 * 60 * 1000L);

    }
}
