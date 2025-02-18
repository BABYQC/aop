package com.example.aop.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author chang qi
 * @date 2025/1/5
 */
@Configuration
public class CustomerConfig {
    private String host;

    private int port;

    public CustomerConfig() {
        System.out.println("default constructor!");
    }

    public CustomerConfig(String host, int port) {
        this.host = host;
        this.port = port;
    }
}
