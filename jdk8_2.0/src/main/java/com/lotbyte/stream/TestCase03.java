package com.lotbyte.stream;

import com.lotbyte.stream.po.Order;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author lp
 * @Date 2019/4/4 18:09
 * @Version 1.0
 * 流的终止操作
 * 查找&匹配
 * 归约
 * Collector收集
 * 收集
 * 汇总
 * 最值
 * 分组
 * 分区
 */
@SuppressWarnings("all")
public class TestCase03 {
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
        test01();

    }

    // 查找 & 匹配
    public static void test01() {
        // 筛选有效订单 匹配是否全部为已支付订单
        System.out.println("allMatch匹配结果:" + ordersList.stream().
                filter((order) -> order.getIsValid() == 1)
                .allMatch((o) -> o.getStatus() != 0));
        // 筛选有效订单 匹配是否存在未支付订单
        System.out.println("anyMatch匹配结果:" + ordersList.stream().
                filter((order) -> order.getIsValid() == 1)
                .anyMatch((o) -> o.getStatus() == 0));
        // 筛选有效订单 订单全部未完成
        System.out.println("noneMatch匹配结果:" + ordersList.stream().
                filter((order) -> order.getIsValid() == 1)
                .noneMatch((o) -> o.getStatus() == 5));
        // 查询有效订单 返回第一条订单(串行时)
        System.out.println(ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .findAny().get());

        //  筛选所有有效订单 返回订单总数
        System.out.println("count结果:" + ordersList.stream().
                filter((order) -> order.getIsValid() == 1).count());
        // 筛选有效订单 返回金额最大订单金额
        System.out.println("订单金额最大值:" + ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .map(Order::getTotal)
                .max(Double::compare)
                .get());
        // 筛选有效订单 返回金额最小订单金额
        System.out.println("订单金额最小值:" + ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .map(Order::getTotal)
                .min(Double::compare)
                .get());
    }


    // 归约 将元素结合 最终合并到一个值  最大 最小 汇总等
    public static void test02() {
        // 计算有效订单总金额
        System.out.println("有效订单总金额:" + ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .map(Order::getTotal)
                .reduce(Double::sum)
                .get());
    }


    /**
     * Collector-收集
     * 转化为以下形式:
     * toList
     * toSet
     * toCollection
     * toMap
     */
    public static void test03() {
        // 筛选有效订单 收集订单列表
        System.out.println(ordersList.stream().
                filter((order) -> order.getIsValid() == 1)
                .collect(Collectors.toList()));


        // 筛选有效订单 并收集订单号与订单金额
        Map<String, Double> map = ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .collect(Collectors.toMap(Order::getOrderNo, Order::getTotal));
        // java8 下对map 进行遍历操作 如果 Map 的 Key 重复了,会报错
        map.forEach((k, v) -> {
            System.out.println("k:" + k + ":v:" + v);
        });
    }

    /**
     * Collector-汇总
     * countintg():用于计算总和
     * count():用于计算总和（推荐使用，写法更简洁）
     * summingInt() ，summingLong()，summingDouble():用于计算总和
     * averagingInt()，averagingLong()，averagingDouble()用于平均
     * summarizingInt，summarizingLong，summarizingDouble 同样可以实现计算总和，平均等操作，
     * 比如summarizingInt 结果会返回IntSummaryStatistics 类型 ，然后通过get方法获取对应汇总值即可
     */
    public static void test04() {
        //筛选有效订单 返回订单总数
        System.out.println("count结果:" + ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .collect(Collectors.counting())
        );
        System.out.println("count结果:" + ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .count()
        );

        // 筛选有效订单 返回订单总金额
        System.out.println("订单总金额:" + ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .collect(Collectors.summarizingDouble(Order::getTotal))
        );
        System.out.println("订单总金额:" + ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .mapToDouble(Order::getTotal).sum()
        );
        System.out.println("订单总金额:" + ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .map(Order::getTotal).reduce(Double::sum)
                .get()
        );

        // 返回用户id=20 有效订单平均每笔消费
        System.out.println("用户id=20 有效订单平均每笔消费金额:" + ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .filter((order -> order.getUserId() == 20))
                .collect(Collectors.averagingDouble(Order::getTotal))
        );
        System.out.println("用户id=20 有效订单平均每笔消费金额:" + ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .filter((order -> order.getUserId() == 20))
                .mapToDouble(Order::getTotal)
                .average().getAsDouble()
        );
        System.out.println("用户id=20 有效订单平均每笔消费金额:" + ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .filter((order -> order.getUserId() == 20))
                .collect(
                        Collectors.summarizingDouble(Order::getTotal)).getAverage()
        );

        // 筛选所有有效订单 并计算订单总金额
        System.out.println("订单总金额:" + ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .collect(Collectors.summingDouble(Order::getTotal))
        );
        // 筛选所有有效订单 并计算最小订单金额
        System.out.println("最小订单金额:" + ordersList.stream().
                filter((order) -> order.getIsValid() == 1)
                .map(Order::getTotal)
                .collect(Collectors.minBy(Double::compare))
        );
        // 筛选所有有效订单 并计算最大订单金额
        System.out.println("最大订单金额:" + ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .map(Order::getTotal)
                .collect(Collectors.maxBy(Double::compare))
        );
    }

    /**
     * Collector-最值
     * maxBy，minBy 两个方法，需要一个 Comparator 接口作为参数，实现最大 最小值获取操作
     */
    public  static  void test05(){
        // 筛选有效订单 计算最小订单金额
        System.out.println("最小订单金额:"+ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .map(Order::getTotal)
                .collect(Collectors.minBy(Double::compare))
        );
        // 筛选所有有效订单 计算最大订单金额
        System.out.println("最大订单金额:"+ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .map(Order::getTotal).collect(Collectors.maxBy(Double::compare))
        );
    }


    /**
     * Collector-分组
     * groupingBy 用于将数据分组，最终返回一个 Map 类型  借助第二参数实现多级分组
     */
    public static  void test06(){
        //根据有效订单支付状态进行分组操作
        Map<Integer,List<Order>> g01=ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .collect(Collectors.groupingBy(Order::getStatus));
        g01.forEach((status,order)->{
            System.out.println("----------------");
            System.out.println("订单状态:"+status);
            order.forEach(System.out::println);
        });
        // 分组-查询有效订单 根据用户id和支付状态进行分组
        Map<Integer,Map<String,List<Order>>> g02= ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .collect(Collectors.groupingBy(Order::getUserId,Collectors.groupingBy((o)->{
                    if(o.getStatus()==0){
                        return "未支付";
                    }else if (o.getStatus()==1){
                        return "已支付";
                    }else if (o.getStatus()==2){
                        return "待发货";
                    }else if (o.getStatus()==3){
                        return "已发货";
                    }else if (o.getStatus()==4){
                        return "已接收";
                    } else{
                        return "已完成";
                    }
                })));
        g02.forEach((userId,m)->{
            System.out.println("用户id:"+userId+"-->有效订单如下:");
            m.forEach((status,os)->{
                System.out.println("状态:"+status+"---订单列表如下:");
                os.forEach(System.out::println);
            });
            System.out.println("-----------------------");
        });
    }


    /**
     * Collector-分组
     *  partitioningBy 分区
     *       分区与分组的区别在于，分区是按照 true 和 false 来分的，
     *      因此partitioningBy 接受的参数的 lambda 也是 T -> boolean
     */
    public static void test07(){
        // 分区操作  筛选订单金额>1000 的有效订单
        Map<Boolean,List<Order>> g03= ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .collect(Collectors.partitioningBy((o)->o.getTotal()>1000));
        g03.forEach((b,os)->{
            System.out.println("分区结果:"+b+"--列表结果:");
            os.forEach(System.out::println);
        });

        // 拼接操作 筛选有效订单 并进行拼接
        String orderStr=ordersList.stream()
                .filter((order) -> order.getIsValid() == 1)
                .map(Order::getOrderNo)
                .collect(Collectors.joining(","));
        System.out.println(orderStr);
    }






}
