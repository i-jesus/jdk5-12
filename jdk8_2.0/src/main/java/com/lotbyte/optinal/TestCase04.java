package com.lotbyte.optinal;


import java.util.Arrays;
import java.util.Optional;

/**
 * @author lp
 * @Date 2019/4/4 14:28
 * @Version 1.0
 * map & flatMap 操作
 */
public class TestCase04 {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable("java8 is so eays!!!");
        System.out.println(optional.map((str) -> str.toUpperCase()).get());
        // 将function结果值包装为 Optinal 类型返回
        System.out.println(optional.flatMap((str) -> Optional.ofNullable(str.toUpperCase())).get());

    }
}
