package com.ljh.thread.synchronous_control;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liujiahan
 * @Title: InterruptLock
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/20
 * @ModifiedBy:
 */
public class InterruptLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    public InterruptLock(int lock) {
        this.lock = lock;
    }

    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "线程退出");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptLock interruptLock1 = new InterruptLock(1);
        InterruptLock interruptLock2 = new InterruptLock(2);
        Thread t1 = new Thread(interruptLock1);
        Thread t2 = new Thread(interruptLock2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();

    }
}
