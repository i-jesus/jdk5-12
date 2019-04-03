package com.lotbyte.method.reference;

import com.lotbyte.method.reference.po.User;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author lp
 * @Date 2019/4/3 16:00
 * @Version 1.0
 */
public class TestCase01 {
    public static void main(String[] args) {

        /**
         * Lambda 表达式  实例化User 对象
         */
        Supplier<User> s01 =()->new User();
        Function<Integer,User>  f01 = (id)->{
            return new User(id);
        };
        f01.apply(2019);
        BiFunction<Integer,String,User> bf01 = (id,uname)->{
            return new User(id,uname);
        };
        bf01.apply(2019,"admin");

        //方法引用 等价写法
        Supplier<User> s02 = User::new;
        Function<Integer,User> f02 = User::new;
        f02.apply(2019);
        BiFunction<Integer,String,User> bf02 = User::new;
        bf02.apply(2019,"admin");
    }
}
