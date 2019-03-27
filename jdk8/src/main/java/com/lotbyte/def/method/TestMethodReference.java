package com.lotbyte.def.method;

import java.util.function.BiFunction;

/**
 * @author lp
 * @Date 2019/3/25 14:12
 * @Version 1.0
 */
public class TestMethodReference {
    public static void main(String[] args) {
       A a= TestMethodReference::add;
       System.out.println(a.add(1, 2));



       TestMethodReference m = new TestMethodReference();
       A s= m::test;
       System.out.println(s.add(10, 20));



      //A ss= TestMethodReference::test;
       String str="hello";
       BiFunction<Integer,Integer,String> f= str::substring;
       System.out.println(f.apply(1, 3));






    }



    public  int test(int a,int b){
        return a+b;
    }


    public static  int add(int a,int b){
        return a+b;
    }



}


