package com.ljh.thread.future.pattern;

/**
 * @author liujiahan
 * @Title: RealData
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/12/9
 * @ModifiedBy:
 */

/**
 * RealData类
 */
public class RealData implements Data {
    protected final String result;

    public RealData(String para) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        result = sb.toString();
    }


    @Override
    public String getResult() {
        return result;
    }
}
