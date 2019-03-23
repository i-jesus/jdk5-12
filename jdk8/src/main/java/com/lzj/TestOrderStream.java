package com.lzj;

import com.lzj.po.Order;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lp
 * @Date 2019/3/22 17:53
 * @Version 1.0
 */
public class TestOrderStream {
    public static void main(String[] args) {
        Order order01 = new Order(1,10,"20190301",
                new Date(),"上海市-浦东区",new Date(),new Date(),4,1,100.0);
        Order order02 = new Order(2,20,"20190302",
                new Date(),"北京市四惠区",new Date(),new Date(),1,1,2000.0);

        Order order03 = new Order(3,20,"20190303",
                new Date(),"北京市-朝阳区",new Date(),new Date(),4,1,500.0);

        Order order04 = new Order(4,40,"20190304",
                new Date(),"北京市-大兴区",new Date(),new Date(),4,0,256.0);
        Order order05 = new Order(5,40,"20190304",
                new Date(),"上海市-松江区",new Date(),new Date(),4,0,1000.0);
        List<Order> ordersList= Arrays.asList(order01,order02,order03,order04,order05);
        // 过滤订单集合 有效订单 并打印到控制台
        //ordersList.stream().filter((order)->order.getIsValid()==1).forEach(System.out::println);

        // 过滤订单集合有效订单 取前两条有效订单 并打印到控制台
        //ordersList.stream().filter((order)->order.getIsValid()==1).limit(2).forEach(System.out::println);

        // 过滤订单集合有效订单 取最后一条记录
        //ordersList.stream().filter((order)->order.getIsValid()==1).skip(ordersList.size()-2).forEach(System.out::println);

        // 过滤订单集合无效订单 去除订单号为20190304的重复记录
        //ordersList.stream().filter((order)->order.getIsValid()==0).distinct().forEach(System.out::println);
        //过滤订单集合有效订单  获取所有订单订单编号
       // ordersList.stream().filter((order)->order.getIsValid()==1).map((order)->order.getOrderNo()).forEach(System.out::println);


        //过滤有效订单 并根据用户id 进行排序
       /* ordersList.stream().filter((order)->order.getIsValid()==1)
                .sorted((o1,o2)->o1.getUserId()-o2.getUserId()).forEach(System.out::println);
        System.out.println("----------");
        ordersList.stream().filter((order)->order.getIsValid()==1)
                .sorted(Comparator.comparingInt(Order::getUserId)).forEach(System.out::println);*/

        /**
         * 过滤有效订单
         * 定制排序:如果订单状态相同 根据订单创建时间排序 反之根据订单状态排序
         */
    /*    ordersList.stream().filter((order)->order.getIsValid()==1)
                .sorted((o1,o2)->{
                    if(o1.getStatus().equals(o2.getStatus())){
                        return o1.getCreateDate().compareTo(o2.getCreateDate());
                    }else{
                        return o1.getStatus().compareTo(o2.getStatus());
                    }
                }).forEach(System.out::println);
*/

 /*       List<String> list = new ArrayList<>();
        list.add("aaa bbb ccc");
        list.add("ddd eee fff");
        list.add("ggg hhh iii");

        list = list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
        list.forEach(System.out::println);*/

        // 过滤有效订单  并分离每个订单下收货地址市区信息
        //ordersList.stream().map(o->o.getAddress().split("-")).flatMap(Arrays::stream).forEach(System.out::println);


        /***********
         * 流的终止
         */
        // 筛选所有有效订单  匹配用户id =20 的所有订单 全部匹配即为true
        System.out.println("allMatch匹配结果:"+ordersList.stream().
                filter((order) -> order.getIsValid() == 1).allMatch((o) -> o.getUserId() == 20));
        // 筛选所有有效订单  匹配用户id =20 的所有订单 存在记录即为true
        System.out.println("anyMatch匹配结果:"+ordersList.stream().
                filter((order) -> order.getIsValid() == 1).anyMatch((o) -> o.getUserId() == 20));
        // 筛选所有有效订单  匹配用户id =20 的所有订单  未找到即为true
        System.out.println("noneMatch匹配结果:"+ordersList.stream().
                filter((order) -> order.getIsValid() == 1).noneMatch((o) -> o.getUserId() == 20));

        // 筛选所有有效订单 返回第一条记录
        System.out.println("findFirst匹配结果:"+ordersList.stream().
                filter((order) -> order.getIsValid() == 1).findFirst());


        // 筛选所有有效订单 返回金额最大订单值
        Optional<Double> max=ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .map(Order::getTotal).max(Double::compare);
        System.out.println("订单金额最大值:"+max.get());
        // 筛选所有有效订单 返回金额最小订单值
        Optional<Double> min=ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .map(Order::getTotal).min(Double::compare);
        System.out.println("订单金额最小值:"+min.get());


        // 归约操作  计算有效订单总金额
        System.out.println("有效订单总金额:"+ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .map(Order::getTotal).reduce(Double::sum).get());


        // 收集操作
        // 筛选所有有效订单 并收集订单列表
        List<Order> orders= ordersList.stream().filter((order) -> order.getIsValid() == 1).collect(Collectors.toList());
        orders.forEach(System.out::println);
        // 筛选所有有效订单 并收集订单号 与 订单金额
        Map<String,Double> map=ordersList.stream().filter((order) -> order.getIsValid() == 1).
                collect(Collectors.toMap(Order::getOrderNo, Order::getTotal));
        // java8 下对map 进行遍历操作
        map.forEach((k,v)->{
            System.out.println("k:"+k+":v:"+v);
        });


        // 汇总操作
        //筛选所有有效订单 返回订单总数
        System.out.println("count结果:"+ordersList.stream().
                filter((order) -> order.getIsValid() == 1).collect(Collectors.counting()));
        System.out.println("count结果:"+ordersList.stream().
                filter((order) -> order.getIsValid() == 1).count());

        //  返回订单总金额
        System.out.println("订单总金额:"+ordersList.stream().
                filter((order) -> order.getIsValid() == 1).collect(Collectors.summarizingDouble(Order::getTotal)));
        System.out.println("订单总金额:"+ordersList.stream().
                filter((order) -> order.getIsValid() == 1).mapToDouble(Order::getTotal).sum());
        System.out.println("订单总金额:"+ordersList.stream().
                filter((order) -> order.getIsValid() == 1).map(Order::getTotal).reduce(Double::sum).get());

        // 返回 用户id=20 有效订单平均每笔消息金额
        System.out.println("用户id=20 有效订单平均每笔消费金额:"+ordersList.stream().
                filter((order) -> order.getIsValid() == 1).
                filter((order -> order.getUserId()==20))
                .collect(Collectors.averagingDouble(Order::getTotal)));
        System.out.println("用户id=20 有效订单平均每笔消费金额:"+
                ordersList.stream().
                filter((order) -> order.getIsValid() == 1).
                filter((order -> order.getUserId()==20))
                        .mapToDouble(Order::getTotal).average().getAsDouble());

        System.out.println("用户id=20 有效订单平均每笔消费金额:"+
                ordersList.stream().
                        filter((order) -> order.getIsValid() == 1).
                        filter((order -> order.getUserId()==20))
                        .collect(Collectors.summarizingDouble(Order::getTotal)).getAverage());

        // 筛选所有有效订单 并计算订单总金额
        System.out.println("订单总金额:"+ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .collect(Collectors.summingDouble(Order::getTotal)));
        // 筛选所有有效订单 并计算最小订单金额
        System.out.println("最小订单金额:"+ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .map(Order::getTotal).collect(Collectors.minBy(Double::compare)));
        // 筛选所有有效订单 并计算最大订单金额
        System.out.println("最大订单金额:"+ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .map(Order::getTotal).collect(Collectors.maxBy(Double::compare)));


        // 取最值



        // 分组-根据有效订单支付状态进行分组操作
        Map<Integer,List<Order>> g01=ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .collect(Collectors.groupingBy(Order::getStatus));
        g01.forEach((status,order)->{
            System.out.println("----------------");
            System.out.println("订单状态:"+status);
            order.forEach(System.out::println);
        });

        // 分组-查询有效订单 根据用户id 和 支付状态进行分组
       Map<Integer,Map<String,List<Order>>> g02= ordersList.stream().filter((order) -> order.getIsValid() == 1)
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


        // 分区操作  筛选订单金额>1000 的有效订单
        Map<Boolean,List<Order>> g03= ordersList.stream().filter((order) -> order.getIsValid() == 1)
                .collect(Collectors.partitioningBy((o)->o.getTotal()>1000));
        g03.forEach((b,os)->{
            System.out.println("分区结果:"+b+"--列表结果:");
            os.forEach(System.out::println);
        });

        // 拼接操作 筛选有效订单 并进行拼接
        String orderStr=ordersList.stream().filter((order) -> order.getIsValid() == 1).map(Order::getOrderNo)
                .collect(Collectors.joining(","));
        System.out.println(orderStr);




    }

    /*public static Stream<Order> filterCharacter(Order order) {
        List<Order> list = new ArrayList<Order>();

        for (Character character : str.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }*/
}
