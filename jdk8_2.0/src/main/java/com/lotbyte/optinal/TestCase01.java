package com.lotbyte.optinal;

import java.util.Optional;

/**
 * @author lp
 * @Date 2019/4/4 9:35
 * @Version 1.0
 * Optinal对象构建&值获取
 */
@SuppressWarnings("all")
public class TestCase01 {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("java8");

        // NullPointerException空指针异常  值不能为空
        optional = Optional.of(null);
        optional = Optional.ofNullable("java8");
        System.out.println(optional.get());
        System.out.println(optional.orElse("java"));
        System.out.println(optional.orElseGet(()-> "java"));
        System.out.println(optional.orElseThrow(()->new RuntimeException()));

        // 值可空  推荐使用
        optional = Optional.ofNullable(null);
        // 运行时抛出NoSuchElementException异常
        System.out.println(optional.get());
        System.out.println(optional.orElse("java"));
        System.out.println(optional.orElseGet(()-> "java"));
        System.out.println(optional.orElseThrow(()->new RuntimeException()));
    }
}
