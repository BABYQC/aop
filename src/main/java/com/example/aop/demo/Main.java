package com.example.aop.demo;

import com.example.aop.mapper.CloudFileMapper;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Proxy;

/**
 * @author chang qi
 * @date 2024/10/29
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Proxy.newProxyInstance(CloudFileMapper.class.getClassLoader(), new Class[]{CloudFileMapper.class}, ((proxy, method, args1) -> {
            System.out.println("aop");
            Object result = method.invoke(args1);
            return result;
        }));
        Agent agent = new Agent();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new AgentDecorator());
        proxyFactory.setTarget(agent);

        proxyFactory.addAdvisors();

        Agent proxy = (Agent) proxyFactory.getProxy();

        agent.speak();
        System.out.println("--------------------------");
        proxy.speak();
        Thread.sleep(60 * 60 * 1000L);

    }
}
