package com.lotbyte.function;

import com.lotbyte.lambda.po.Goods;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author lp
 * @Date 2019/4/3 14:26
 * @Version 1.0
 * 高阶函数:
 *    方法形参为函数接口
 *    方法结果为函数接口
 */
public class TestCase05 {
    public static void main(String[] args) {
        String action = "";
        Predicate<String> p01 = (a) -> StringUtils.isBlank(a);
        /**
         * 如果action 为空  或 index  或 main 转发到网站主页面
         * 链式判断
         */
        if (p01.or((a) -> a.equals("index")).or((a) -> a.equals("main")).test(action)) {
            System.out.println("网站主页面...");
        } else {
            System.out.println("其他页面...");
        }

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

        // 销量 与 评论排序 高阶函数使用
        Comparator<Goods> comparator = (g1,g2)->g1.getSale()-g2.getSale();
        goods.sort(comparator.thenComparing(Comparator.comparing(g3 -> g3.getComment())));
        goods.forEach((g)->System.out.println(g));
    }
}
