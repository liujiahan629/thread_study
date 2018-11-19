package com.ljh.thread.basic;

/**
 * @author liujiahan
 * @Title: ThreadGroupTest
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/18
 * @ModifiedBy:
 */
public class ThreadGroupTest implements Runnable {
    public void run() {
        String groupName = Thread.currentThread().getThreadGroup().getName() + "--" + Thread.currentThread().getName();
        while (true){
            System.out.println(" i am " + groupName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("testGroup");
        Thread t1 = new Thread(threadGroup,new ThreadGroupTest(),"T1");
        Thread t2 = new Thread(threadGroup,new ThreadGroupTest(),"T2");
        t1.start();
        t2.start();
        System.out.println(threadGroup.activeCount());
        threadGroup.list();
    }
}
