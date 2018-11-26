package com.ljh.thread.thread_pool;

import java.util.concurrent.*;

/**
 * @author liujiahan
 * @Title: ThreadFactoryDemo
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/25
 * @ModifiedBy:
 */
public class ThreadFactoryDemo {
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
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
            public Thread newThread(Runnable r) {
                Thread t =new Thread(r);
                t.setDaemon(true);
                System.out.println("create thread" + t.getName());
                return  t;
            }
        });
        for (int i = 0; i < 10 ; i++) {
            es.submit(myTask);
        }

    }
}
