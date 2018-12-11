package com.ljh.thread.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liujiahan
 * @Title: ThreadLocalDemoGC
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/12/9
 * @ModifiedBy:
 */
public class ThreadLocalDemoGC {

    static volatile  ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected void finalize() throws Throwable{
            System.out.println(this.toString() + "is gc");
        }
    };

    static volatile CountDownLatch cd = new CountDownLatch(1000);
    public static class ParseDate implements Runnable{
        int i=0;
        public ParseDate(int i ){
            this.i=i;
        }



        @Override
        public void run() {
            try {
                if(t1.get()==null){
                    t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"){
                        @Override
                        protected void finalize() throws Throwable {
                            System.out.println(this.toString() + "is gc");
                        }
                    });
                    System.out.println(Thread.currentThread().getName() + "create simpleDateFormat");
                }
                Date t = t1.get().parse("2018-12-09 12:29:" + i%60);
                //System.out.println(i + ":" + t);
            } catch (ParseException e) {
                e.printStackTrace();
            }finally {
                cd.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            es.execute(new ParseDate(i));
        }
        cd.await();
        System.out.println("mission complete");
        t1=null;
        System.gc();
        System.out.println("first Gc Complete");
        t1= new ThreadLocal<SimpleDateFormat>();
        cd = new CountDownLatch(10000);
        for (int i = 0; i < 1000; i++) {
            es.execute(new ParseDate(i));
        }
        cd .await();
        Thread.sleep(1000);
        System.gc();
        System.out.println("second GC complate");

    }

}
