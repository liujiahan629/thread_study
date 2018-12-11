package com.ljh.thread.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liujiahan
 * @Title: ThreadLocalTest
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/12/9
 * @ModifiedBy:
 */
public class ThreadLocalTest {
    //1,线程不安全
    //2,加锁控制
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //3使用ThreadLocal容器
    public static ThreadLocal<SimpleDateFormat> ts = new ThreadLocal<SimpleDateFormat>();

    public static class ParseDate implements Runnable{
        int i=0;
        public ParseDate(int i ){
            this.i=i;
        }
        @Override
        public void run() {
            try {
                //线程不安全
                //Date t = sdf.parse("2018-12-09 12:29:" + i%60);

                //通过threadocal人手一个SimpleDateFormat
                if(ts.get()==null){
                    ts.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date t = ts.get().parse("2018-12-09 12:29:" + i%60);
                System.out.println(i + ":" + t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            es.execute(new ParseDate(i));
        }
    }
}
