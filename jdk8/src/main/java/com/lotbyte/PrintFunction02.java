package com.lotbyte;

/**
 * 定义函数式接口
 */
@FunctionalInterface
public interface PrintFunction02<T,R> {
    R print(T t);
}
