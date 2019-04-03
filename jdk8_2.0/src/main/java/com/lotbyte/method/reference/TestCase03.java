package com.lotbyte.method.reference;

import com.lotbyte.method.reference.po.User;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author lp
 * @Date 2019/4/3 16:47
 * @Version 1.0
 *
 * 实例对象方法引用
 */
public class TestCase03 {
    public static void main(String[] args) {


        //方法引用构造User 对象
        BiFunction<Integer,String,User> bf02 = User::new;
        User u02 = bf02.apply(2019,"admin");
        // 调用实例对象方法
        Supplier<String> s01 = ()->u02.getUserName();
        System.out.println(s01.get());

        // 方法引用 等价Lambda 写法
        Supplier<String> s02 = u02::getUserName;
        System.out.println(s02.get());
    }
}
