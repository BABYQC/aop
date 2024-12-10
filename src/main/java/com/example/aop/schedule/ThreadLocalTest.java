package com.example.aop.schedule;

import com.example.aop.vo.UserTokenContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * ThreadLocal测试类
 *
 * @author chang qi
 * @date 2024/11/16
 */
@Slf4j
@Component
public class ThreadLocalTest {


//    @Async
//    @Scheduled(fixedRate = 10 * 1000)
    public void testToken() {
        Thread thread = Thread.currentThread();
        log.info("线程id: {}, 线程名称: {}", thread.getId(), thread.getName());
        UserTokenContext.setToken(thread.getName());
        log.info("线程Id：{}, userToken: {}", thread.getId(), UserTokenContext.getToken());
    }

    // todo 在容器中的ThreadLocal
    // todo 在线程池中的线程，会因为线程复用，如果不remove，会导致脏数据
    // todo threadLocal的内存溢出
}
