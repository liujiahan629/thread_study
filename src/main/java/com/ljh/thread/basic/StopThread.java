package com.ljh.thread.basic;

/**
 * @author liujiahan
 * @Title: ChangeObjectThread
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/18
 * @ModifiedBy:
 */
public class StopThread extends Thread {

    volatile boolean stopme = false;

    //停止方法
    public void stopMe() {
        stopme = true;
    }

    @Override
    public void run() {
        while (true) {
            //死循环中如果出现停止标识，则直接跳出
            if (stopme) {
                System.out.println("exit by stop me");
                break;
            }

            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
