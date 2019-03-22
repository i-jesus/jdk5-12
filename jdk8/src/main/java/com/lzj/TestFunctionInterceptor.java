package com.lzj;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author lp
 * @Date 2019/3/22 11:31
 * @Version 1.0
 * 函数式接口测试
 */
public class TestFunctionInterceptor {
    public static void main(String[] args) {
        /**
         * 借助Lambda表达式实现Predicate test方法
         */
         Predicate<String> p01=(str)->str.isEmpty()||str.trim().isEmpty();
         /**
         * 测试传入的字符串是否为空*/

        System.out.println(p01.test(""));
        System.out.println(p01.test("  "));
        System.out.println(p01.test("admin"));


        /**
         * 借助Lambda表达式实现Consumer  accept方法
         */
        /*Consumer<Collection> c01 = (collection) -> {
            if (null != collection && collection.size() > 0) {
                for (Object c : collection) {
                    System.out.println(c);
                }
            }
        };

        List<String> list = new ArrayList<String>();
        list.add("诸葛亮");
        list.add("曹操");
        list.add("关羽");

        // 遍历list 输出元素内容到控制台
        c01.accept(list);*/

        // 实现用户密码 Base64加密操作
/*        Function<String, String> f01 = (password) -> Base64.getEncoder().encodeToString(password.getBytes());
        // 输出加密后的字符串
        System.out.println(f01.apply("123456"));*/


        /**
         * 产生一个session工厂对象
         */
        Supplier<SessionFactory> s = () -> {
            return new SessionFactory();
        };
        s.get().info();

        SessionFactory s02 = new SessionFactory();

    }
}

