package com.lzj;



/**
 * @author lp
 * @Date 2019/3/22 9:06
 * @Version 1.0
 */
public class Test {
     final static  Integer a2=512;
     final static  Integer b2=1024;
    public static void main(String[] args) {
        /**
         * 匿名实现IMathOperation add 方法
         */
        IMathOperation m01=new IMathOperation() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        };
        // 调用接口实例方法 实现加法操作
        System.out.println(m01.add(1024, 1024));


        /**
         * 使用Lambda 表达式 实现接口add 方法
         */
        IMathOperation m02 = (a,b)->a+b;
        System.out.println(m02.add(1024 ,1024));


        IMathOperation m03=(a,b)->a+b;
        m03.add(a2,b2);

    }
}
