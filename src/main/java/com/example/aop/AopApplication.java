package com.example.aop;

import com.example.aop.vo.Config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@MapperScan("com.example.aop.mapper")
@EnableScheduling
@EnableAsync
@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class AopApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(AopApplication.class, args);
//		Config redisConfig = context.getBean("redisConfig", Config.class);
	}


}
