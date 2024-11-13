package com.example.aop.demo;

import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Proxy;

/**
 * @author chang qi
 * @date 2024/10/29
 */
public class Main {
    public static void main(String[] args) {
        Agent agent = new Agent();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new AgentDecorator());
        proxyFactory.setTarget(agent);

        proxyFactory.addAdvisors();

        Agent proxy = (Agent) proxyFactory.getProxy();

        agent.speak();
        System.out.println("--------------------------");
        proxy.speak();

    }
}
