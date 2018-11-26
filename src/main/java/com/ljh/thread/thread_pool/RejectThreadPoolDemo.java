package com.ljh.thread.thread_pool;

import java.util.concurrent.*;

/**
 * @author liujiahan
 * @Title: RejectThreadPoolDemo
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/25
 * @ModifiedBy:
 */
public class RejectThreadPoolDemo {
    public static class MyTask implements Runnable{

        public void run() {
            System.out.println(System.currentTimeMillis() + "Thread Name:" + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FixThreadPoolDemo.MyTask myTask = new FixThreadPoolDemo.MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r.toString() + "is discard");
            }
        });
        for (int i = 0; i < 20 ; i++) {
            es.submit(myTask);
        }

    }
}
