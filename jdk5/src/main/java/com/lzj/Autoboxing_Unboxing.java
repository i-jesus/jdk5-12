package com.lzj;

/**
 * @author lp
 * @Date 2019/3/21 14:53
 * @Version 1.0
 * 自动化拆箱与装箱
 */
public class Autoboxing_Unboxing {
    public static void main(String[] args) {
        //test_autoboxing_unboxing_5();
        //test_boxing_unboxing_4();
        test_autoboxing_unboxing02();
    }


    /**
     * java5自动化拆箱与装箱代码示例
     */
    public static  void test_autoboxing_unboxing_5(){
        /**
         * 自动化装箱:程序在运行时自动将基本数据类型转换为包装类型；
         * Java5 开始提供了自动装箱功能
         *  比如我要定义一个2048的整型对象 从Java5 开始就可以这样来编写你的代码
         *  这个过程程序在运行中会自动根据我们提供的2048数字创建一个Integer对象
         */
        Integer i=2048;// 装箱
        System.out.println(i);

        /**
         *自动化拆箱:程序在运行时自动将包装类型转换为基本数据类型。
         * Java5 开始提供了自动装箱功能
         * 比如我要定义一个1024的整型对象l 此时程序在运行时就会产生装箱操作
         * 后续定义变量x 值为l 此时Integer 类型的l变量会将自已引用的1024数值赋给x 这个过程就是拆箱
         */
        Integer l=1024;// 装箱
        int x=l;// 拆箱
        System.out.println(x);
    }


    /**
     * Java5之前拆箱与装箱代码示例
     */
    public static void test_boxing_unboxing_4(){
        /**
         * Java5 之前得到一个2048的包装对象
         *   需要通过手动方式借助带参构造器 构造2048 Integer 对象
         */
        Integer i=new Integer(2048);
        System.out.println(i);

        /**
         * Java5 之前由包装类型得到一个2048的基本类型
         *   通过调用Integer包装对象intValue方法获取整数2048
         */
        int h=i.intValue();
        System.out.println(h);
    }




    /**
     * 面试问题01
     */
    public  static void test_autoboxing_unboxing01(){
        Integer b1 = 66;
        Integer b2 = 66;
        Integer b3 = 201;
        Integer b4 = 201;
        System.out.println(b1 == b2);// true or false?
        System.out.println(b3 == b4);// true or false?
    }

    /**
     * 面试问题02
     */
    public  static  void test_autoboxing_unboxing02(){
        Double b1 = 66.0;
        Double b2 = 66.0;
        Double b3 = 201.0;
        Double b4 = 201.0;
        System.out.println(b1==b2);
        System.out.println(b3==b4);
    }






    }
