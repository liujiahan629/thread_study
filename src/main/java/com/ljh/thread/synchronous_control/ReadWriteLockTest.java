package com.ljh.thread.synchronous_control;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liujiahan
 * @Title: ReadWriteLockTest
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/20
 * @ModifiedBy:
 */
public class ReadWriteLockTest {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = reentrantReadWriteLock.readLock();
    private static Lock writeLock = reentrantReadWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            return value;
        } finally {
            lock.unlock();
        }

    }

    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = index;
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        final ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
        Runnable readRunnale = new Runnable() {
            public void run() {
                try {
                    readWriteLockTest.handleRead(readLock);
                    //readWriteLockTest.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        Runnable writeRunnale = new Runnable() {
            public void run() {
                try {
                    readWriteLockTest.handleWrite(readLock, new Random().nextInt());
                    //readWriteLockTest.handleWrite(lock,new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 18; i++) {
            new Thread(readRunnale).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(writeRunnale).start();
        }
    }
}
