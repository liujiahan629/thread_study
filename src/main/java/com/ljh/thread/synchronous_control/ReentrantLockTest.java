package com.ljh.thread.synchronous_control;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liujiahan
 * @Title: ReentrantLockTest
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/20
 * @ModifiedBy:
 */
public class ReentrantLockTest implements Runnable{
    public static ReentrantLock lock  =new ReentrantLock();

    public static int i =0;

    public void run() {
        for (int j = 0; j < 1000; j++) {
            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        Thread t1 = new Thread(reentrantLockTest);
        Thread t2 = new Thread(reentrantLockTest);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
