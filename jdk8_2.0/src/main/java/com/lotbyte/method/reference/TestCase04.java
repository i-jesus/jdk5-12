package com.lotbyte.method.reference;

import com.lotbyte.lambda.po.Goods;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lp
 * @Date 2019/4/3 17:12
 * @Version 1.0
 * 方法引用04-特定类型任意对象的实例方法
 */
@SuppressWarnings("all")
public class TestCase04 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(10,2,30,5,8,10,60,99,101);
        List<String> emails = Arrays.asList("126@126.com"," ","","java8@163.com");
        Goods g01=new Goods(1,"小米9",1789,200, BigDecimal.valueOf(2500));
        Goods g02=new Goods(2,"华为Mate20",5000,3000, BigDecimal.valueOf(7000));
        Goods g03=new Goods(3,"OPPO R17",2000,2827, BigDecimal.valueOf(1500));
        Goods g04=new Goods(4,"魅族 Note9",2000,1600, BigDecimal.valueOf(1600));
        Goods g05=new Goods(5,"一加6T",8000,5000, BigDecimal.valueOf(3500));
        List<Goods> goods= Arrays.asList(g01,g02,g03,g04,g05);

        // Lambda 对集合list元素排序  list 存放整数元素
        list.sort((a1,a2)->a1-a2);
        // Lambda 对集合goods 按销量排序
        goods.sort((g1,g2)->g1.getSale()-g2.getSale());
        // 过滤邮箱集合空串
        emails.stream().filter((e) -> StringUtils.isNoneBlank(e))
                .collect(Collectors.toList());

        // 任意对象的实例方法引用 对集合list元素排序
        list.sort(Comparator.comparing(Integer::intValue));
        // 任意对象的实例方法引用 对集合goods 按销量排序
        goods.sort(Comparator.comparing(Goods::getSale));
        // 过滤邮箱集合空串
        emails.stream().filter(StringUtils::isNoneBlank).collect(Collectors.toList());
    }
}
