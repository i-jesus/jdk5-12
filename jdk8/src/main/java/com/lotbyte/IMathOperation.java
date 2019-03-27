package com.lotbyte;

/**
 * @author lp
 * @Date 2019/3/22 9:20
 * @Version 1.0
 * 接口默认方法
 */
public interface IMathOperation {
    /**
     * 定义接口默认方法 支持方法形参
     */
    default void print(){
        System.out.println("这是数值运算基本接口。。。");
    }


    /**
     * 定义静态默认方法
     */
    static void version(){
        System.out.println("这是1.0版简易计算器");
    }

    /**
     * 整数加法运算方法
     * @param a
     * @param b
     * @return
     */
    public int add(int a,int b);
}
