package com.example.aop.config;

import com.example.aop.vo.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: chang qi
 * @Date: 2024/12/10
 */
@Configuration
public class ScheduleConfig {

    @Bean
    public Config redisConfig() {
        return new Config();
    }
}
