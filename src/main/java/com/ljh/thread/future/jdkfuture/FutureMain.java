package com.ljh.thread.future.jdkfuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author liujiahan
 * @Title: FutureMain
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/12/9
 * @ModifiedBy:
 */
public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = new FutureTask<String>(new RealData("ljh"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(futureTask);

        System.out.println("请求完毕");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据=" + futureTask.get());

    }
}
