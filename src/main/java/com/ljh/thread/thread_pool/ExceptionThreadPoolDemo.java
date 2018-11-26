package com.ljh.thread.thread_pool;

import java.util.concurrent.*;

/**
 * @author liujiahan
 * @Title: ExceptionThreadPoolDemo
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/25
 * @ModifiedBy:
 */
public class ExceptionThreadPoolDemo {
    public static class MyTask implements Runnable {
        int a, b;

        public MyTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public void run() {

            double re = a / b;
            System.out.println(re);

        }
    }
    public static void main(String[] args) {
        //ExecutorService es = new TraceThreadPoolExecutor(0,Integer.MAX_VALUE,0L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        ExecutorService es = new ThreadPoolExecutor(0,Integer.MAX_VALUE,0L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            //不进行日志打印
            //es.submit(new MyTask(100,i));
            //进行日志打印，只是打印了具体方法错误：Exception in thread "pool-1-thread-1" java.lang.ArithmeticException: / by zero
            //	at com.ljh.thread.thread_pool.ExceptionThreadPoolDemo$MyTask.run(ExceptionThreadPoolDemo.java:24)
            //	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
            //	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
            //	at java.lang.Thread.run(Thread.java:748)
            es.execute(new MyTask(100,i));
        }

    }
}
