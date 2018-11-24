package com.ljh.thread.synchronous_control;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liujiahan
 * @Title: FairLock
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/20
 * @ModifiedBy:
 */
public class FairLock implements Runnable {
    public static ReentrantLock fairLock = new ReentrantLock(true);

    public void run() {
        while (true){
            try{
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + "get lock");
            }finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Thread t1 = new Thread(fairLock,"thread1");
        Thread t2 = new Thread(fairLock,"thread2");
        t1.start();
        t2.start();
    }
}
