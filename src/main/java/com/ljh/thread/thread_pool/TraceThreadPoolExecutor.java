package com.ljh.thread.thread_pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liujiahan
 * @Title: TraceThreadPoolExecutor
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/25
 * @ModifiedBy:
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor {
    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command,ljhTrace(),Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task,ljhTrace(),Thread.currentThread().getName()));
    }

    private Exception ljhTrace(){
        return new Exception("ljh-stack-trace");
    }

    private Runnable wrap(final Runnable task , final  Exception ljhException,String threadName){
        return  new Runnable() {
            public void run() {
                try {
                    task.run();
                }catch (Exception e){
                    ljhException.printStackTrace();
                     e.printStackTrace();
                }

            }
        };
    }
}
