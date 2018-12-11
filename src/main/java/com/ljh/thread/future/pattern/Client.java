package com.ljh.thread.future.pattern;

/**
 * @author liujiahan
 * @Title: Client
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/12/9
 * @ModifiedBy:
 */
public class Client {

    public Data request(final String queryStr) {
        final FutureData futureData = new FutureData();
        //单起个线程进行数据处理
        new Thread() {
            @Override
            public void run() {
                RealData realData = new RealData(queryStr);
                futureData.setRealData(realData);
            }
        }.start();
        //立即返回
        return futureData;
    }


    public static void main(String[] args) {
        Client client = new Client();

        Data data = client.request("ljhname");
        System.out.println("请求完毕");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据" + data.getResult());
    }
}
