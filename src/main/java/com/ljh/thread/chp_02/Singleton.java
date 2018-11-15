package com.ljh.thread.chp_02;

/**
 * @author liujiahan
 * @Title: Singleton
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/5
 * @ModifiedBy:
 */
public class Singleton {

    private static Singleton singleton =null;//懒汉模式
    //private static Singleton singleton = new Singleton();//饿汉模式;

    public Singleton(){}

    public static synchronized Singleton newInstance(){
        if(null==singleton){
            singleton = new Singleton();
        }
        return singleton;
    }
}
