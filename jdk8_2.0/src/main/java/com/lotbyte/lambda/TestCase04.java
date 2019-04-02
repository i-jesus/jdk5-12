package com.lotbyte.lambda;


import com.lotbyte.lambda.po.Goods;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * @author lp
 * @Date 2019/4/1 20:26
 * @Version 1.0
 */
public class TestCase04 {
    public static void main(String[] args) {

        int  num = 2019;
         Comparator<Goods> comparator = (g1, g2)-> {
             System.out.println(num);
             return g1.getSale() - g2.getSale();
        };
        Goods g01=new Goods(1,"小米9",1789,200, BigDecimal.valueOf(2500));
        Goods g02=new Goods(2,"华为Mate20",5000,3000, BigDecimal.valueOf(7000));
        System.out.println(comparator.compare(g01, g02));

    }
}
