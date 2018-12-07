package com.ljh.thread.concurrentclass;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author liujiahan
 * @Title: Test
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/26
 * @ModifiedBy:
 */
public class Test {

    public static Map m = Collections.synchronizedMap(new HashMap<>());

    public static  Map m2 = new ConcurrentHashMap();

    public  static List list1 = Collections.synchronizedList(new ArrayList<>());

    public static ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

    public static CopyOnWriteArrayList copyOnWriteArrayList  = new CopyOnWriteArrayList();

    public static BlockingQueue blockingQueue = new ArrayBlockingQueue(3);

    public static void main(String[] args) {


    }
}
