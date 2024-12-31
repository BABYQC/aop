package com.example.aop.demo;

import jdk.internal.misc.Unsafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chang qi
 * @date 2024/12/28
 */
@Slf4j
public class LockDemo {
    private final ReentrantLock lock = new ReentrantLock();
    // Unsafe
    private static final Unsafe U = Unsafe.getUnsafe();
    
    /** CLH Nodes */
    abstract static class Node {
        volatile Node prev;       // initially attached via casTail
        volatile Node next;       // visibly nonnull when signallable
        Thread waiter;            // visibly nonnull when enqueued
        volatile int status;      // written by owner, atomic bit ops by others

        // methods for atomic operations
        final boolean casPrev(Node c, Node v) {  // for cleanQueue
            return U.weakCompareAndSetReference(this, PREV, c, v);
        }
        final boolean casNext(Node c, Node v) {  // for cleanQueue
            return U.weakCompareAndSetReference(this, NEXT, c, v);
        }
        final int getAndUnsetStatus(int v) {     // for signalling
            return U.getAndBitwiseAndInt(this, STATUS, ~v);
        }
        final void setPrevRelaxed(Node p) {      // for off-queue assignment
            U.putReference(this, PREV, p);
        }
        final void setStatusRelaxed(int s) {     // for off-queue assignment
            U.putInt(this, STATUS, s);
        }
        final void clearStatus() {               // for reducing unneeded signals
            U.putIntOpaque(this, STATUS, 0);
        }

        protected static final long STATUS
                = U.objectFieldOffset(Node.class, "status");
        protected static final long NEXT
                = U.objectFieldOffset(Node.class, "next");
        protected static final long PREV
                = U.objectFieldOffset(Node.class, "prev");
    }

    // Concrete classes tagged by type
    static final class ExclusiveNode extends Node { }

    private static final ThreadPoolExecutor executors = new ThreadPoolExecutor(5, 5, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(100));
    public static void main(String[] args) {
        LockDemo aLockDemo = new LockDemo();
        LockDemo bLockDemo = new LockDemo();
        executors.execute(aLockDemo::lockDemo);
//        executors.execute(bLockDemo::lockDemo);
        executors.execute(aLockDemo::lockDemo);
        System.out.println();
    }

    private void lockDemo() {
        Thread curThread = Thread.currentThread();
        System.out.printf("线程:id:[%s] - name:[%s] 开始尝试获取锁%n", curThread.getId(), curThread.getName());
        lock.lock();
        try {
            System.out.printf("线程:id:[%s] - name:[%s] 获取到锁！%n", curThread.getId(), curThread.getName());
            Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
            System.out.printf("线程:id:[%s] - name:[%s] 释放了锁！%n", curThread.getId(), curThread.getName());
        }
    }

}
