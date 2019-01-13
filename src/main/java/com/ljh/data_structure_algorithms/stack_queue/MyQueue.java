package com.ljh.data_structure_algorithms.stack_queue;

import java.util.*;

/**
 * @author liujiahan
 * @Title: MyQueue
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Created on 2019/1/1
 * @ModifiedBy:
 */
public class MyQueue {


    public static void main(String[] args) {
        Stack<Integer> putStack = new Stack<Integer>();
        Stack<Integer> outStack = new Stack<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        List<Integer> listResult = new ArrayList<Integer>();
        queue.add(1);
        queue.peek();
        queue.pop();
        queue.pollLast();
        queue.size();
        String s = "sss{}";
        Set<Integer> tempSet = new HashSet<Integer>();
        tempSet.add(12);
        tempSet.add(12);
        Map<String,Integer> map = new HashMap<>();
        map.put("123",1);
        Integer noResult = -1;
        for(int i=0;i<s.length();i++){
            String sindex =s.substring(i,i+1);
            System.out.println(sindex);
        }

        Map<String,String> tempMap = new HashMap<String,String>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 02-01;
            }
        });
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

    }
}
