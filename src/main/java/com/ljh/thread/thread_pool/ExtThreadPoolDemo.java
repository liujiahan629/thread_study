package com.ljh.thread.thread_pool;

import java.util.concurrent.*;

/**
 * @author liujiahan
 * @Title: ExtThreadPoolDemo
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/25
 * @ModifiedBy:
 */
public class ExtThreadPoolDemo {
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

    public static void main(String[] args) throws InterruptedException {
        FixThreadPoolDemo.MyTask myTask = new FixThreadPoolDemo.MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10)){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行线程：" + r.toString() +"==="  + t.getName());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成线程：" + r.toString());
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出" );
            }
        };
        for (int i = 0; i < 10 ; i++) {
            es.submit(myTask);
        }
        Thread.sleep(3000);
        es.shutdown();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
