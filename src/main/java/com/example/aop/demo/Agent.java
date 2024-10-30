package com.example.aop.demo;

import lombok.Data;

/**
 * @author chang qi
 * @date 2024/10/29
 */
@Data
public class Agent {
    public void speak() {
        System.out.println("Bond");
    }
}
