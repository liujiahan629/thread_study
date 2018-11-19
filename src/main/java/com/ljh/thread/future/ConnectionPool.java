package com.ljh.thread.future;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liujiahan
 * @Title: ConnectionPool
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/15
 * @ModifiedBy:
 */
public class ConnectionPool {

    private ConcurrentHashMap<String,Connection> pool = new ConcurrentHashMap<String, Connection>();

    public Connection getConnection(String key){
        Connection conn = null;
        if(pool.containsKey(key)){
            conn=pool.get(key);
        }else{
            conn = createConnection();
            pool.putIfAbsent(key,conn);
        }
        return  conn;
    }


    public Connection createConnection(){
        return new Connection();
    }

    class Connection{}
}
