package com.ljh.data_structure_algorithms.stack_queue;

import java.util.*;

/**
 * @author liujiahan
 * @Title: Test
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Created on 2019/1/3
 * @ModifiedBy:
 */
public class Test {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> tempMap = new HashMap<String,List<String>>();
        for(String s :strs){
            List<String> tempList = new ArrayList<String>();
            char[] tempChar = s.toCharArray();
            Arrays.sort(tempChar);
            String charString = String.valueOf(tempChar);
            if(tempMap.containsKey(charString)){
                tempMap.get(charString).add(charString);
            }else{
                tempList.add(charString);
                tempMap.put(charString,tempList);
            }
            s.toCharArray();
        }
        return new ArrayList(tempMap.values());

    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer,Integer> tempMap = new HashMap<Integer,Integer>();

        for(int n=0 ; n<nums.length;n++){
            tempMap.put(n,nums[n]);
        }

        for(int i=0 ; i<nums.length;i++){
            tempMap.remove(i,nums[i]);
            Map<Integer,Integer> tempMap2=tempMap;
            for(int j=i+1;j<nums.length;j++){
                tempMap2.remove(j,nums[j]);
                if(tempMap2.containsValue(0-(nums[i] + nums[j]))){
                    List<Integer> listResult = new ArrayList<Integer>();
                    listResult.add(nums[i]);
                    listResult.add(nums[j]);
                    listResult.add(0-(nums[i] + nums[j]));
                    Collections.sort(listResult);
                    if(!result.contains(listResult)){
                        result.add(listResult);
                    }
                    result.add(listResult);
                }
            }
        }
        return result;
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        if(strs.length == 0){
            return new ArrayList();
        }
        Map<String,List<String>> tempMap = new HashMap<String,List<String>>();
        //初始化26位的数组，用来存储26个字母在每个单词中的个数
        int[] count = new int[26];
        for(String s :strs){
            //初始化都为0
            Arrays.fill(count,0);
            for(char c : s.toCharArray()){
                count[c-'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<26;i++){
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!tempMap.containsKey(key)){
                tempMap.put(key,new ArrayList());
            }
            tempMap.get(key).add(s);
        }
        return new ArrayList(tempMap.values());
    }

    public static String stringToAscii(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }
    public static void main(String[] args) {
//        Test test = new Test();
//        int[] initData =  {3,0,-2,-1,1,2};
//        test.threeSum(initData);
        System.out.println(stringToAscii("刘佳翰"));
    }
}
