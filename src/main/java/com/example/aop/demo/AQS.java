//package com.example.aop.demo;
//
//import java.util.concurrent.atomic.AtomicReference;
//
///**
// * @author chang qi
// * @date 2024/12/28
// */
//public abstract class AQS {
//
//    abstract static class Node {
//        volatile AtomicReference<Node> prev;
//        volatile Node next;
//        Thread waiter;
//        volatile int status;
//
//        final boolean casPrev(Node c, Node v) {  // for cleanQueue
//            return prev.compareAndSet(c, v);
////            return U.weakCompareAndSetReference(this, PREV, c, v);
//        }
//        final boolean casNext(Node c, Node v) {  // for cleanQueue
//            return U.weakCompareAndSetReference(this, NEXT, c, v);
//        }
//        final int getAndUnsetStatus(int v) {     // for signalling
//            return U.getAndBitwiseAndInt(this, STATUS, ~v);
//        }
//        final void setPrevRelaxed(Node p) {      // for off-queue assignment
//            U.putReference(this, PREV, p);
//        }
//        final void setStatusRelaxed(int s) {     // for off-queue assignment
//            U.putInt(this, STATUS, s);
//        }
//        final void clearStatus() {               // for reducing unneeded signals
//            U.putIntOpaque(this, STATUS, 0);
//        }
//
//        protected static final long STATUS
//                = U.objectFieldOffset(Node.class, "status");
//        protected static final long NEXT
//                = U.objectFieldOffset(Node.class, "next");
//        protected static final long PREV
//                = U.objectFieldOffset(Node.class, "prev");
//    }
//}
