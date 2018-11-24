package com.ljh.thread.synchronous_control;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liujiahan
 * @Title: CountDownLatchTest
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/20
 * @ModifiedBy:
 */
public class CountDownLatchTest implements Runnable {
    static final CountDownLatch countDownLatch = new CountDownLatch(10);
    static final CountDownLatchTest countDownLatchTest = new CountDownLatchTest();

    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10)*100);
            System.out.println("check complete");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i <10 ; i++) {
            executorService.execute(countDownLatchTest);
        }

        countDownLatch.await();
        System.out.println("all complete");
        executorService.shutdown();
    }
}
