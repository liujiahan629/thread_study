package com.ljh.thread.basic;

/**
 * @author liujiahan
 * @Title: WaitNotifyThread
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/18
 * @ModifiedBy:
 */
public class WaitNotifyThread {
    final static Object ob = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (ob) {
                System.out.println(System.currentTimeMillis() + "t1 is start");

                try {
                    System.out.println(System.currentTimeMillis() + "t1 is wait");
                    ob.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "t1 is end");

            }
        }
    }


    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (ob) {
                System.out.println(System.currentTimeMillis() + "t2 is start");


                System.out.println(System.currentTimeMillis() + "t2 is notify start");
                ob.notify();
                System.out.println(System.currentTimeMillis() + "t2 is notify end");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "t2 is end");

            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
