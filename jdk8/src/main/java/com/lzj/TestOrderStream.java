package com.lzj;

import com.lzj.po.Order;

import java.util.*;
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
                new Date(),"上海市-浦东区",new Date(),new Date(),4,1);
        Order order02 = new Order(2,30,"20190302",
                new Date(),"北京市四惠区",new Date(),new Date(),1,1);

        Order order03 = new Order(3,20,"20190303",
                new Date(),"北京市-朝阳区",new Date(),new Date(),4,1);

        Order order04 = new Order(4,40,"20190304",
                new Date(),"北京市-大兴区",new Date(),new Date(),4,0);
        Order order05 = new Order(4,40,"20190304",
                new Date(),"上海市-松江区",new Date(),new Date(),4,0);
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




    }

    /*public static Stream<Order> filterCharacter(Order order) {
        List<Order> list = new ArrayList<Order>();

        for (Character character : str.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }*/
}
