package com.ljh.thread.synchronous_control;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author liujiahan
 * @Title: SemaphoreTest
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/20
 * @ModifiedBy:
 */
public class SemaphoreTest implements  Runnable {
    final Semaphore semaphore =new Semaphore(5);

    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "done");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final SemaphoreTest semaphoreTest = new SemaphoreTest();
        for (int i = 0; i <20 ; i++) {
            executorService.execute(semaphoreTest);
        }
    }
}
