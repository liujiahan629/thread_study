package com.ljh.thread.wait_notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liujiahan
 * @Title: Run
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/5
 * @ModifiedBy:
 */
public class Run {

    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadA a = new ThreadA(lock);
            a.start();
            Thread.sleep(50);
            ThreadB b = new ThreadB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        ///
//        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0L,
//                TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<>(10),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());
//
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 0L,
//                TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<>(10),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());


    }
}
