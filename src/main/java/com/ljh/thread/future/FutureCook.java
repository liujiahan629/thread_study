package com.ljh.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author liujiahan
 * @Title: FutureCook
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/15
 * @ModifiedBy:
 */
public class FutureCook {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime =System.currentTimeMillis();

        Callable<Chuju> onlineShopping = new Callable<Chuju>() {
            public Chuju call() throws Exception {
                System.out.println("第一步：下单");
                System.out.println("下一步：等待送货");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("后一步：快递送到");
                return new Chuju();
            }
        };

        FutureTask<Chuju> task = new FutureTask<Chuju>(onlineShopping);
        new Thread(task).start();

        //第二步 去超市买食材
        Thread.sleep(2000);
        Shicai shicai = new Shicai();
        System.out.println("第二步食材到位");

        System.out.println("第三步：开始展现厨艺");
        if(!task.isDone()){
            System.out.println("第三步：厨具还没有到，心情好就等着吧……");
        }
        Chuju chuju=task.get();
        System.out.println("第三步：厨具到位，开始展现厨艺");
        cook(chuju,shicai);
        System.out.println("总共用时：" + (System.currentTimeMillis() - startTime) + "ms");

    }


    static void cook(Chuju chuju, Shicai shicai){

    }

    static class  Chuju{}
    static class  Shicai{}
}
