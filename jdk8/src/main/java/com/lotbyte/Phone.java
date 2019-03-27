package com.lotbyte;

/**
 * 定义手机接口  提供默认info方法
 */
public interface Phone {
    default void info(){
        System.out.println("这是一部手机");
    }


}
