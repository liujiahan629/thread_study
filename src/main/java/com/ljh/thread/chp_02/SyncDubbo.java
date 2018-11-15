package com.ljh.thread.chp_02;

/**
 * @author liujiahan
 * @Title: SyncDubbo
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/5
 * @ModifiedBy:
 */


/**
 * Synchronized的特性：1，可重入性；2，出现异常时，锁自动释放；3，将任意对象作为监视器
 */
public class SyncDubbo {
    public synchronized void method1() {
        System.out.println("method1-----");
        method2();
    }

    public synchronized void method2() {
        System.out.println("method2-----");
        method3();
    }

    public synchronized void method3() {
        System.out.println("method3-----");
    }

    public static void main(String[] args) {
        final SyncDubbo syncDubbo = new SyncDubbo();

        new Thread(new Runnable() {
            public void run() {
                syncDubbo.method1();
            }
        }).start();
    }

}
