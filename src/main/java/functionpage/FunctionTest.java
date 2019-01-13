package functionpage;

import java.util.Arrays;

/**
 * @author liujiahan
 * @Title: FunctionTest
 * @Copyright: Copyright (c) 2018
 * @Description:
 * @Created on 2018/12/16
 * @ModifiedBy:
 */
public class FunctionTest {
    static int[] arr = {1,2,3,4,5,6,7};
    @FunctionalInterface
    public static interface intHandler{
        void hadler(int i);
    }

    public static void main(String[] args) {


        Arrays.stream(arr).map(x->(x%2 == 0?x:x+1)).forEach(System.out ::println);
    }
}
