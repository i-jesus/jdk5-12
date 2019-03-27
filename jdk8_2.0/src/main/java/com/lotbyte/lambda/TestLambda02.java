package com.lotbyte.lambda;

import com.lotbyte.po.Goods;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lp
 * @Date 2019/3/26 12:08
 * @Version 1.0
 * 热销商品排序
 */
public class TestLambda02 {
    public static void main(String[] args) {
        /**
         * 实际开发数据通常从数据库获取
         * 这里使用测试数据
         */
        Goods g01=new Goods(1,"小米9",1789,200, BigDecimal.valueOf(2500));
        Goods g02=new Goods(2,"华为Mate20",5000,3000, BigDecimal.valueOf(7000));
        Goods g03=new Goods(3,"OPPO R17",2000,2827, BigDecimal.valueOf(1500));
        Goods g04=new Goods(4,"魅族 Note9",2000,1600, BigDecimal.valueOf(1600));
        Goods g05=new Goods(5,"一加6T",8000,5000, BigDecimal.valueOf(3500));
        List<Goods> goods= Arrays.asList(g01,g02,g03,g04,g05);

        System.out.println("-----------商品排序前--------------");
        for(Goods g:goods){
            System.out.println(g);
        }
        // 对商品记录按销量进行排序 Java7的写法
        /**
         * java7 下集合排序实现  使用Collections.sort 方法实现
         */
        Collections.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return o1.getSale()-o2.getSale();
            }
        });
        System.out.println("-----------商品排序后--------------");
         for(Goods g:goods){
             System.out.println(g);
         }

        // 使用Lambda 对商品记录按销量进行排序
       /* goods.sort((g1,g2)->g1.getSale()-g2.getSale());
        System.out.println("-----------商品排序后--------------");
        goods.forEach(System.out::println);*/

        // 多个条件排序情况 Lambda 配置Stream  销量+价格排序  销量相等时按照价格排序
/*        goods =goods.stream().sorted((g1,g2)->g1.getSale()-g2.getSale())
                .sorted((g1,g2)->g1.getPrice().compareTo(g2.getPrice()))
                .collect(Collectors.toList());
        System.out.println("-----------商品排序后--------------");
        goods.forEach(System.out::println);*/

        goods.sort(Comparator.comparing(Goods::getSale).thenComparing(Goods::getPrice));
        System.out.println("-----------商品排序后--------------");
        goods.forEach(System.out::println);
        goods.stream().sorted(Comparator.comparingInt(Goods::getSale).thenComparing(Goods::getPrice))
                .collect(Collectors.toList()).forEach(System.out::println);
        //goods.stream().map()
    }
}
