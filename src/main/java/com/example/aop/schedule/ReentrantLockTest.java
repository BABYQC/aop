package com.example.aop.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: chang qi
 * @Date: 2024/12/26
 */
@Slf4j
@Component
public class ReentrantLockTest {
    private final ReentrantLock valveSyncPushLock = new ReentrantLock(true);
    @Async
    @Scheduled(cron = "0/5 * 10-23 * * ?")
    public void schedulePushValveAutoChargeToTransfer() {
        Thread curThread = Thread.currentThread();
        try {
            log.info("当前线程:id:{} - name:{}; 尝试获取锁valveSyncPushLock", curThread.getId(), curThread.getName());
            if (valveSyncPushLock.tryLock(10, TimeUnit.SECONDS)) {
                try {
                    log.info("当前线程:id:{} - name:{}; 获取了锁valveSyncPushLock", curThread.getId(), curThread.getName());
                    System.out.println("do something......");
                    Thread.sleep(1000 * 30);
                } finally {
                    valveSyncPushLock.unlock();
                    log.info("当前线程:id:{} - name:{}; 释放了锁valveSyncPushLock", curThread.getId(), curThread.getName());
                }
            }
        } catch (InterruptedException e) {
            log.error("当前线程:id:{} - name:{};", curThread.getId(), curThread.getName(), e);
            throw new RuntimeException(e);
        }

    }
}
