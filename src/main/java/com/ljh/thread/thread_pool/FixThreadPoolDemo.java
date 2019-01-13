package com.ljh.thread.thread_pool;


import java.util.concurrent.*;

/**
 * @author liujiahan
 * @Title: FixThreadPoolDemo
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/24
 * @ModifiedBy:
 */
public class FixThreadPoolDemo {

    public static class MyTask implements Runnable{
        @Override
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
        MyTask myTask = new MyTask();
        int size =5;
        //下篇说下阿里技术规范插件对这个的提示问题
       ExecutorService executorService = new ThreadPoolExecutor(size,size,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
//        ExecutorService executorService2 = new ThreadPoolExecutor(size,size,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),namedThreadFactory);
//
//        ExecutorService es = Executors.newFixedThreadPool(size);
        for (int i = 0; i < 10 ; i++) {
            executorService.submit(myTask);
        }

    }

}
