package com.ljh.thread.wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujiahan
 * @Title: MyList
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/5
 * @ModifiedBy:
 */
public class MyList {
    private static List list = new ArrayList();

    public static void add() {
        list.add("我是元素");
    }

    public static int size() {
        return list.size();
    }
}
