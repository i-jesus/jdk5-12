package com.lzj;

import java.util.Arrays;
import java.util.List;

/**
 * @author lp
 * @Date 2019/3/22 17:23
 * @Version 1.0
 * 流基本操作
 */
public class TestStream {
    public static void main(String[] args) {
        /**
         * 定义集合l1 并为集合创建串行流
         */
        List<String> l1 = Arrays.asList("周星驰", "周杰伦", "周星星", "周润发");
        // 返回串行流
        l1.stream();
        // 返回并行流
        l1.parallelStream();



    }
}
