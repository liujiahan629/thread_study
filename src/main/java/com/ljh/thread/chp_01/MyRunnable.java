package com.ljh.thread.chp_01;

/**
 * @author liujiahan
 * @Title: MyRunnable
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/5
 * @ModifiedBy:
 */
public class MyRunnable implements Runnable {

    public void run() {
        System.out.println( Thread.currentThread().getName() + "===ljh");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread =new Thread(myRunnable,"ljh");
        thread.start();
    }
}
