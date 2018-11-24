package com.ljh.thread.synchronous_control;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liujiahan
 * @Title: CyclicBarrierTest
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/20
 * @ModifiedBy:
 */
public class CyclicBarrierTest {

    public static class Soldier implements Runnable {
        private String soldier;
        private final CyclicBarrier cyclicBarrier;

        Soldier(CyclicBarrier cyclicBarrier, String soldierName) {
            this.soldier = soldierName;
            this.cyclicBarrier = cyclicBarrier;
        }

        public void run() {

            try {
                //等待所有士兵到齐
                cyclicBarrier.await();
                doWork();
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        void doWork() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier + "do work");
        }
    }


    public static class BarrierRun implements Runnable {

        boolean flag;
        int n;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            this.n = n;
        }

        public void run() {
            if (flag) {
                System.out.println("soldier" + n + "个，do work");
            } else {
                System.out.println("soldier" + n + "个，集合完毕");
                flag = true;
            }
        }
    }


    public static void main(String[] args) {
        final int n = 10;
        Thread[] allSoldier = new Thread[n];
        boolean flag = false;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n, new BarrierRun(flag, n));
        //
        System.out.println("集合");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "+soldier come");
            allSoldier[i] = new Thread(new Soldier(cyclicBarrier, "soldier" + n));
            allSoldier[i].start();

        }
    }
}
