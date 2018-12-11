package com.ljh.thread.threadlocal;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author liujiahan
 * @Title: ThreadLocalHSTest
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/12/9
 * @ModifiedBy:
 */
public class ThreadLocalHSTest {

    public static final int Get_COUNT = 1000000;
    public static final int THREAD_COUNT = 4;
    static ExecutorService es = Executors.newFixedThreadPool(THREAD_COUNT);

    public static Random rd =new Random(123);

    public static ThreadLocal<Random> trd = new ThreadLocal<Random>(){
        @Override
        protected Random initialValue() {
            return new Random(123);
        }
    };

    public static class RndTask implements Callable<Long>{
        private int mode =0;
        public RndTask(int mode){
            this.mode = mode;
        }

        public Random getRandom(){
            if(mode==0){
                return rd;
            }else if(mode ==1 ){
                return trd.get();
            }else{
                return  null;
            }

        }

        @Override
        public Long call() throws Exception {
            long b = System.currentTimeMillis();
            for (int i = 0; i < Get_COUNT; i++) {
                getRandom().nextInt();
            }

            long e= System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "spend" + (e-b) + "ms");
            return e-b;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Long>[] future = new Future[Get_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            future[i] = es.submit(new RndTask(0));
        }

        long totalTime = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totalTime +=future[i].get();
        }
        System.out.println("多线程访问同一个Random实例：" + totalTime + "ms");


        for (int i = 0; i < THREAD_COUNT; i++) {
            future[i] = es.submit(new RndTask(1));
        }
        totalTime = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totalTime +=future[i].get();
        }
        System.out.println("使用ThreadLocal包装Random实例：" + totalTime + "ms");
    }
}
