package com.lzj;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lp
 * @Date 2019/3/22 17:23
 * @Version 1.0
 * 流基本操作-流的创建
 */
public class TestStream {
    public static void main(String[] args) throws IOException {
        /**
         * 定义集合l1 并为集合创建串行流
         */
        List<String> l1 = Arrays.asList("周星驰", "周杰伦", "周星星", "周润发");
        // 返回串行流
        l1.stream();
        // 返回并行流
        l1.parallelStream();

        //值创建流 生成一个字符串流
        Stream<String> stream = Stream.of("aaa", "bbb", "ccc");
        stream.forEach(System.out::println);

        // 只取索引第 1 到第 2 位的：
        int[] a = {1, 2, 3, 4};
        Arrays.stream(a, 1, 3).forEach(System.out :: println);

        //每个元素是给定文件的其中一行
        Stream<String> stream02 = Files.lines(Paths.get("data.txt"));




    }
}
