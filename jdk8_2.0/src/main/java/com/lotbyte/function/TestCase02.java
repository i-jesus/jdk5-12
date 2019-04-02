package com.lotbyte.function;

import com.lotbyte.function.po.Goods;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author lp
 * @Date 2019/4/2 18:03
 * @Version 1.0
 */
public class TestCase02 {

    public static void main(String[] args) {
        /**
         * 实际开发数据通常从数据库获取
         * 这里使用测试数据
         */
        Goods g01=new Goods(1,"iPad 2018款",3000,180, BigDecimal.valueOf(2300));
        Goods g02=new Goods(6,"小米平板4",5000,600, BigDecimal.valueOf(1900));
        Goods g03=new Goods(9,"微软 Surface Pro 6",100,50, BigDecimal.valueOf(8500));
        Goods g04=new Goods(20,"华为 荣耀平板5",1600,480, BigDecimal.valueOf(1500));
        List<Goods> goods= Arrays.asList(g01,g02,g03,g04);
        // 遍历平板电脑数据
        goods.forEach(g->{
            System.out.println(g);
        });
    }
}
