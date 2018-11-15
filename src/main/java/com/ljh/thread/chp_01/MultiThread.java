package com.ljh.thread.chp_01;

/**
 * @author liujiahan
 * @Title: MultiThread
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/5
 * @ModifiedBy:
 */

//一个对象有一把锁！多个线程多个锁！
public class MultiThread {
    //private static int num =200;
    private  int num =200;

    public synchronized void printNum(String threadName,String tag){
        if(tag.equals("a")){
            num = num -100;
            System.out.println(threadName +  " tag a ,set num over");
        }else {
            num = num - 200;
            System.out.println(threadName + " tag b,set num over!");
        }

        System.out.println(threadName + " tag " + tag + ", num = " + num);
    }

    public static void main(String[] args) {
        final MultiThread multiThread1 = new MultiThread();
        final MultiThread multiThread2 = new MultiThread();

        new Thread(new Runnable() {
            public void run() {
                multiThread1.printNum("thread1", "a");
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                multiThread2.printNum("thread2", "b");
            }
        }).start();

    }
}
