package com.lzj;

/**
 * 定义函数式接口
 * 接口上标注@FunctionalInterface 注解
 */
@FunctionalInterface
public interface ICollectionService {
    /**
     * 定义打印方法
     */
    void print();
}
