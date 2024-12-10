package com.example.aop.demo;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

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
