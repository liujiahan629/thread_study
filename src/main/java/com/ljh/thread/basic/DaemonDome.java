package com.ljh.thread.basic;

/**
 * @author liujiahan
 * @Title: DaemonDome
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/18
 * @ModifiedBy:
 */
public class DaemonDome {

    public static class T1 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println(" i am live");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new T1();
        t.setDaemon(true);
        t.start();

        Thread.sleep(2000);
    }
}
