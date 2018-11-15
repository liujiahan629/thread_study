package com.ljh.thread.wait_notify;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liujiahan
 * @Title: TestHashMap
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/6
 * @ModifiedBy:
 */
public class TestHashMap {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"lljh");
        System.out.println(map.get(1));
        System.out.println("lszh".hashCode());

    }
}
