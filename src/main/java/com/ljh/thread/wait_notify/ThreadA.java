package com.ljh.thread.wait_notify;

/**
 * @author liujiahan
 * @Title: ThreadA
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/5
 * @ModifiedBy:
 */
public class ThreadA extends Thread {

    private Object lock;

    public  ThreadA (Object lock){
        super();
        this.lock=lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
                if (MyList.size() != 5) {
                    System.out.println("wait begin " + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end  " + System.currentTimeMillis());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
