package com.example.aop.demo;

/**
 * @Author: chang qi
 * @Date: 2025/1/6
 */
public class AgentImpl implements IAgent {
    @Override
    public void speak() {
        System.out.println("AgentImpl!");
    }
}
