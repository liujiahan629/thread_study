package com.ljh.thread.basic;

/**
 * @author liujiahan
 * @Title: InterruptThread
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/18
 * @ModifiedBy:
 */
public class InterruptThread {


    /**
     * public void interrupt() 中断线程
     * public static boolean interrupted() 判断是否被中断，并清除当前中断标识
     * public boolean isInterrupted() 判断是否被中断
     */
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    //判断如果有中断标识，则直接跳出
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("exit by interrupted");
                        break;
                    }

                    System.out.println(System.currentTimeMillis());
                    Thread.yield();
                }
            }
        };

        t1.start();
        Thread.sleep(2000);
        //打上中断标识
        t1.interrupt();
    }
}
