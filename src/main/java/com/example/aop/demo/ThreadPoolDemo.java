package com.example.aop.demo;

import java.util.concurrent.*;

/**
 * @Author: chang qi
 * @Date: 2025/2/24
 */
public class ThreadPoolDemo {

    private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            1, 1, 1, TimeUnit.MINUTES,
            new SynchronousQueue<>());

    private static final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            int finalI = i;
            threadPool.execute(() -> System.out.println(finalI));
//            Thread.sleep(10 * 1000);
        }
//        threadPool.shutdown();
    }
}
