package com.ljh.thread.chp_02;

/**
 * @author liujiahan
 * @Title: DubbleSingleton
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/5
 * @ModifiedBy:
 */
public class DubbleSingleton {

    private static volatile DubbleSingleton instance;

    public static DubbleSingleton getInstance(){
        if(instance == null){
            try {
                //模拟初始化对象的准备时间...
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //类上加锁，表示当前对象不可以在其他线程的时候创建
            synchronized (DubbleSingleton.class) {
                //如果不加这一层判断的话，这样的话每一个线程会得到一个实例
                //而不是所有的线程的到的是一个实例
                if(instance == null){
                    instance = new DubbleSingleton();
                }
            }
        }
        return instance;
    }
}
