package com.ljh.thread.future;

/**
 * @author liujiahan
 * @Title: CommonCook
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/11/15
 * @ModifiedBy:
 */
public class CommonCook {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        //first 网购厨具
        OnlineShopping thread = new OnlineShopping();
        thread.start();
        thread.join();//保证厨具送到
        //第二步 去超市买食材
        Thread.sleep(2000);
        Shicai shicai = new Shicai();
        System.out.println("第二步食材到位");

        System.out.println("第三步：开始展现厨艺");
        cook(thread.chuju,shicai);
        System.out.println("总共用时：" + (System.currentTimeMillis() - startTime) + "ms");

    }

    static class OnlineShopping extends Thread{
        private Chuju chuju;


        @Override
        public void run() {
            System.out.println("第一步：下单");
            System.out.println("下一步：等待送货");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("后一步：快递送到");
            chuju = new Chuju();
        }
    }

    static void cook(Chuju chuju,Shicai shicai){

    }

    static class  Chuju{}
    static class  Shicai{}
}
