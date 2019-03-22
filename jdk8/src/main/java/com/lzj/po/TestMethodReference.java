package com.lzj.po;

import com.lzj.Phone;
import com.lzj.PrintFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author lp
 * @Date 2019/3/22 14:42
 * @Version 1.0
 * 方法引用测试
 */
public class TestMethodReference {
    public static void main(String[] args) {
        /**
         * 构造器引用
         * 无参构造器
         */
        // 实现Supplier 接口 通过构造器引用
        Supplier<IPhone> factory01= IPhone::new;
        IPhone p01 = factory01.get();
        System.out.println(p01);

        /**
         *  等价的Lambda 写法
         */
        Supplier<IPhone> factory02 = ()->new IPhone();
        IPhone p02 = factory02.get();
        System.out.println(p02);


        /**
         * 当构造器方法存在参数 参数个数为1个时
         */
        Function<Integer,IPhone> factory03 = IPhone::new;
        IPhone p03 = factory03.apply(2019);
        System.out.println(p03);

        /**
         * 等价的Lambda 写法
         */
        Function<Integer,IPhone> factory04 = (id)-> new IPhone(id);
        IPhone p04 = factory04.apply(2019);
        System.out.println(p04);


        /**
         * 当构造器方法存在参数 参数个数为2个时
         */
        BiFunction<Integer,String,IPhone> factory05 = IPhone::new;
        IPhone p05 = factory05.apply(2019,"iphoneX");
        System.out.println(p05);

        /**
         * 等价的Lambda 写法
         */
        BiFunction<Integer,String,IPhone> factory06 = (id,name)-> new IPhone(id,name);
        IPhone p06 = factory06.apply(2019,"iphoneMax");
        System.out.println(p06);


        //  静态方法引用
        PrintFunction pf01= IPhone::info;
        pf01.print();
        /**
         * 等价的Lambda 写法
         */
        PrintFunction pf02 = () -> {
            IPhone.info();
        };
        pf02.print();


        /**
         * 构造器引用 实例化对象
         * 成员方法引用
         */
        BiFunction<Integer,String,IPhone> factory07= IPhone::new;
        IPhone p07 = factory07.apply(2019,"iphoneX");
        PrintFunction pp= p07::mm;
        pp.print();

        /**
         * 等价的Lambda 写法
         */
        BiFunction<Integer,String,IPhone> factory08 = (id,name)-> new IPhone(id,name);
        IPhone p08 = factory08.apply(2019,"iphoneMax");
        PrintFunction pp02 = ()->{
            p08.mm();
        };
        pp02.print();


    }
}
