package com.example.aop.demo;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author chang qi
 * @date 2025/3/1
 */
public class CglibDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Agent.class);
        enhancer.setCallback(new CglibCallBack());
        Agent agent = (Agent) enhancer.create();
        agent.speak();
    }
}
