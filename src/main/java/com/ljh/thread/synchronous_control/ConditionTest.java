package com.ljh.thread.synchronous_control;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liujiahan
 * @Title: ConditionTest
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/20
 * @ModifiedBy:
 */
public class ConditionTest implements Runnable {

    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static Condition condition = reentrantLock.newCondition();

    public void run() {

        try {
            reentrantLock.lock();
            condition.await();
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionTest conditionTest = new ConditionTest();
        Thread t1 = new Thread(conditionTest);
        t1.start();
        Thread.sleep(2000);
        reentrantLock.lock();
        condition.signal();
        reentrantLock.unlock();
    }
}
