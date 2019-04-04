package com.lotbyte.stream;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lp
 * @Date 2019/4/4 15:54
 * @Version 1.0
 *
 * 创建流5种方式
 */
public class TestCase01 {
    public static void main(String[] args) {
        create05();
    }

    /**
     * 集合创建流  常用
     */
    public static void create01() {
        List<String> list = Arrays.asList("周星驰", "周杰伦", "周润发", "周星星");
        Stream<String> s01 = list.stream();// 创建串行流对象
        Stream<String> s02 = list.parallelStream();// 创建并行流对象
    }

    /**
     * 值创建流
     */
    public static void create02() {
        Stream<String> stream = Stream.of("java8", "Spring", "SpringCloud");
    }


    /**
     * 数组创建流
     */
    public static void create03() {
        /**
         * 这里以int 为例   long double 不再举例
         */
        Stream stream = Arrays.stream(Arrays.asList(10, 20, 30, 40).toArray());
        // 根据数组索引范围创建指定Stream
        stream = Arrays.stream(Arrays.asList(10, 20, 30, 40).toArray(), 0, 2);
    }

    /**
     * 文件生成流
     */
    public static void create04() {
        Stream<String> stream = null;
        //根据文件路径创建流  读取文件行内容创建流Stream
        try {
            stream = Files.lines(Paths.get("C:\\java\\jdbc.properties"));
            System.out.println(stream.collect(Collectors.toList()));
            // 指定字符集编码
            stream = Files.lines(Paths.get("C:\\java\\jdbc.properties"), Charset.forName("utf-8"));
            System.out.println(stream.collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 函数生成流
     */
    public static void create05() {
        // 重100 开始 生成偶数流
        Stream.iterate(100, n -> n + 2);
        // 产生1-100 随机数
        Stream.generate(() ->(int) (Math.random() * 100 + 1));
    }

}
