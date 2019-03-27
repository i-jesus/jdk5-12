package com.lotbyte;

import com.lotbyte.po.IPhone;
import com.lotbyte.po.Order;

import java.util.Optional;

/**
 * @author lp
 * @Date 2019/3/23 13:55
 * @Version 1.0
 */
public class TestOptional {
    public static void main(String[] args) {
        /**
         * 构建一个Optional 类_01
         */
        Optional<IPhone> p01 = Optional.empty();
        /**
         * 构建一个Optional 类_02
         */
        Optional<Order> p02= Optional.of(new Order());
        /**
         * 构建一个Optional 类_03
         */
        Order o=null;
        Optional<Order>  p03 = Optional.ofNullable(o);// 订单对象可空
        // 获取对象
        //System.out.println(p03.get());
        // 通过isPresent 判断对象是否为null
        if(p03.isPresent()){
            System.out.println("对象非空!");
        }else{
            System.out.println("对象不存在!");
        }

        // 使用 map flapMap 进行值映射操作
        IPhone phone = new IPhone(2020,"IPhoneY");
        Optional<IPhone> p06 = Optional.of(phone);
        System.out.println(p06.map(IPhone::getName).get());
        // 与 map 处理类似  方法参数为Optional类型
        System.out.println(p06.flatMap((p) -> Optional.of(p.getName())).get());
    }
}
