package com.ljh.thread.basic;

/**
 * @author liujiahan
 * @Title: JoinThread
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/18
 * @ModifiedBy:
 */
public class JoinThread {
    volatile static int i = 0;

    public static  class AddThread extends Thread{
        @Override
        public void run() {
            for(i=0;i<10000;i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        addThread.start();
        //主线程等待addTread执行完毕
        addThread.join();
        System.out.println(i);
    }
}
