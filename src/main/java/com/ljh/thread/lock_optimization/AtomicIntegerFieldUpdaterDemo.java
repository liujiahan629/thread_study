package com.ljh.thread.lock_optimization;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author liujiahan
 * @Title: AtomicIntegerFieldUpdaterDemo
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/12/6
 * @ModifiedBy:
 */

/**
 * 1,Updater只能修改它可见范围内的变量，因为是通过反射获取的，如果不可见就出错；
 * 2，为了确保变量被正确的读取，必须为volatile类型的；
 * 3，不支持static字段操作
 */
public class AtomicIntegerFieldUpdaterDemo {

    public static class Candidate{
        int id;
        volatile int score;
    }

    public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");

    public static AtomicInteger allSocre = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final Candidate stu = new Candidate();
        Thread[] t =new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            t[i] = new Thread(){
                @Override
                public void run() {
                    if(Math.random()>0.4){
                        scoreUpdater.incrementAndGet(stu);
                        allSocre.incrementAndGet();
                    }
                }
            };
            t[i].start();
        }
        for (int i = 0; i < 10000; i++) {
            t[i].join();
        }

        System.out.println("score=" + stu.score);
        System.out.println("allscore=" + allSocre);
    }
}
