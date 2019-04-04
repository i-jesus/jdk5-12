package com.lotbyte.stream;

import com.lotbyte.stream.po.Order;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author lp
 * @Date 2019/4/4 17:11
 * @Version 1.0
 * 流中间操作
 *   筛选和切面
 *   映射
 *   排序
 */
public class TestCase02 {
    private static List<Order> ordersList;

    static {
        Order order01 = new Order(1, 10, "20190301",
                new Date(), "上海市-浦东区", new Date(), new Date(), 4, 1, 100.0);
        Order order02 = new Order(2, 30, "20190302",
                new Date(), "北京市四惠区", new Date(), new Date(), 1, 1, 2000.0);
        Order order03 = new Order(3, 20, "20190303",
                new Date(), "北京市-朝阳区", new Date(), new Date(), 4, 1, 500.0);
        Order order04 = new Order(4, 40, "20190304",
                new Date(), "北京市-大兴区", new Date(), new Date(), 4, 1, 256.0);
        Order order05 = new Order(5, 40, "20190304",
                new Date(), "上海市-松江区", new Date(), new Date(), 4, 1, 1000.0);
        ordersList = Arrays.asList(order01, order02, order03, order04, order05);
    }

    public static void main(String[] args) {
        //test01();
    }

    /**
     * 筛选和切面基本操作
     */
    public static void test01() {
        // 过滤有效订单 并打印到控制台
        ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .forEach(System.out::println);
        // 过滤有效订单 取第一页数据(每页2条记录) 并打印到控制台
        ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .limit(2)
                .forEach(System.out::println);

        // 过滤订单集合有效订单 取最后一条记录
        ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .skip(ordersList.size() - 2)  // 跳过前ordersList.size()-2 记录
                .forEach(System.out::println);

        // 过滤有效订单 取第3页数据(每页2条记录) 并打印到控制台
        ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .skip((3 - 1) * 2)
                .limit(2)
                .forEach(System.out::println);

        // 过滤无效订单 去除重复订单号记录  重写Order equals 与 hashCode 方法
        ordersList.stream().filter((order) -> order.getIsValid() == 0)
                .distinct().forEach(System.out::println);

    }

    /**
     * 映射基本操作
     */
    public static void test02() {
        //过滤有效订单，获取所有订单编号
        ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .map((order) -> order.getOrderNo())
                .forEach(System.out::println);
        // 过滤有效订单  并分离每个订单下收货地址市区信息
        ordersList.stream().map(o -> o.getAddress()
                .split("-"))
                .flatMap(Arrays::stream)
                .forEach(System.out::println);
    }

    /**
     * 排序基本操作
     */
    public static void test03() {
        //过滤有效订单 根据用户id 进行排序
        ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .sorted((o1, o2) -> o1.getUserId() - o2.getUserId())
                .forEach(System.out::println);
        //或者等价写法
        ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .sorted(Comparator.comparingInt(Order::getUserId))
                .forEach(System.out::println);
        //过滤有效订单  如果订单状态相同 根据订单创建时间排序 反之根据订单状态排序
        ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .sorted((o1, o2) -> {
                    if (o1.getStatus().equals(o2.getStatus())) {
                        return o1.getCreateDate().compareTo(o2.getCreateDate());
                    } else {
                        return o1.getStatus().compareTo(o2.getStatus());
                    }
                }).forEach(System.out::println);
        // 等价形式
        ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .sorted(Comparator.comparing(Order::getCreateDate)
                        .thenComparing(Comparator.comparing(Order::getStatus))
                ).forEach(System.out::println);
    }


}
