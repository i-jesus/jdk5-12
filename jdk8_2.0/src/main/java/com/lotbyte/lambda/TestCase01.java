package com.lotbyte.lambda;

import java.math.BigInteger;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * @author lp
 * @Date 2019/3/26 9:47
 * @Version 1.0
 * 案例1_斐波那契数列&阶乘
 */
public class TestCase01 {
    public static void main(String[] args) {
        test02();
    }


    /**
     * java7 代码实现
     */
    public static void test01() {
        // 多线程
        Runnable r01 = new Runnable() {
            public void run() {
                for (int i = 1; i < 100; i++) {
                    // 打印斐波那契数列
                    System.out.println("线程名:" + Thread.currentThread().getName() + "数值" + i + "斐波那契数值为:" + fibonacci(i));
                }
            }
        };
        // 多线程
        Runnable r02 = new Runnable() {
            public void run() {
                for (int i = 1; i < 100; i++) {
                    // 打印1-999 阶乘
                    System.out.println("线程名:" + Thread.currentThread().getName() + "数值" + i + "阶乘值为:" + recursion(BigInteger.valueOf(i)));
                }
            }
        };
        Thread t01 = new Thread(r01);
        Thread t02 = new Thread(r02);
        t01.start();
        t02.start();
    }


    public static void test02() {
        // 使用IntStream 流对象产生1-100
        Runnable r01 = () -> IntStream.rangeClosed(1, 100).forEach(
                (i) -> System.out.println("线程名:" + Thread.currentThread().getName() + "数值" + i + "斐波那契数值为:" + fibonacci(i))
        );
        // 使用IntStream 流对象产生1-100
        Runnable r02 = () -> IntStream.rangeClosed(1, 100).forEach(
                (i) -> System.out.println("线程名:" + Thread.currentThread().getName() + "数值" + i + "阶乘值为:" + recursion(BigInteger.valueOf(i)))
        );
        // 使用构造器方法引用实例化对象Thread
        Function<Runnable, Thread> f01 = Thread::new;
        Function<Runnable, Thread> f02 = Thread::new;
        f01.apply(r01).start();
        f02.apply(r02).start();
    }


    /**
     * 计算斐波那契数值
     *
     * @param n
     * @return
     */
    public static int fibonacci(Integer n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    /**
     * 利用递归计算阶乘
     * 使用int 或 Integer 计算阶乘 当num 值很大时  会超出Integer 范围 使用BigInteger 避免范围越界情况
     */
    public static BigInteger recursion(BigInteger num) {
        BigInteger sum = BigInteger.ONE;
        if (num.compareTo(BigInteger.ZERO) <= 0)
            throw new IllegalArgumentException("必须为正整数!");//抛出不合理参数异常
        if (num.compareTo(BigInteger.ONE) == 0) {
            return BigInteger.ONE;//根据条件,跳出循环
        } else {
            sum = num.multiply(recursion(num.subtract(BigInteger.ONE)));//运用递归计算
            return sum;
        }
    }
}
