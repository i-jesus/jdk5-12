package com.lotbyte;

/**
 * 定义MiPhone子接口 并继承 Phone 父接口 同时也提供info方法
 */
public interface MiPhone extends Phone{
    default void info(){
        System.out.println("这是一部小米手机");
    }
}
