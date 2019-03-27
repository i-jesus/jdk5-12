package com.lotbyte.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author lp
 * @Date 2019/3/26 17:16
 * @Version 1.0
 */
public class Test {
    private int a;

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 9, 7, 6, 10, 20);
        integers.forEach(i -> {
            System.out.println(50 / i);
            /*try {
                int a= 1/0;
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            try {
                ta();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    public  static  void ta () throws  Exception{
        System.out.println("异常测试");
    }
}
