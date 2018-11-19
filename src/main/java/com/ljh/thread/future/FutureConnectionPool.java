package com.ljh.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author liujiahan
 * @Title: FutureConnectionPool
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/15
 * @ModifiedBy:
 */
public class FutureConnectionPool {

    //FutureTask<Connnection>的pool
    private ConcurrentHashMap<String,FutureTask<Connection>> pool = new ConcurrentHashMap<String, FutureTask<Connection>>();

    public Connection getConnection(String key) throws ExecutionException, InterruptedException {
        FutureTask<Connection> connectionFutureTask = pool.get(key);

        if(connectionFutureTask!=null){
            return connectionFutureTask.get();
        }else{
            Callable<Connection> callable = new Callable<Connection>() {
                public Connection call() throws Exception {
                    return createConnection();
                }
            };

            FutureTask<Connection> newTask = new FutureTask<Connection>(callable);
            connectionFutureTask = pool.putIfAbsent(key,newTask);

            if(connectionFutureTask ==null){
                connectionFutureTask = newTask;
                connectionFutureTask.run();
            }

            return connectionFutureTask.get();
        }
    }


    //创建连接
    public Connection createConnection(){
        return new Connection();
    }

    /**
     * 连接类
     */
    class Connection{}
}
