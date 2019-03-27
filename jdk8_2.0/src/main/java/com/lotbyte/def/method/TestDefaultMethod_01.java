package com.lotbyte.def.method;

import com.lotbyte.def.method.inte.MyArrayList;
import com.lotbyte.def.method.inte.MyList;
import com.lotbyte.def.method.po.UserDto;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;


/**
 * @author lp
 * @Date 2019/3/27 17:13
 * @Version 1.0
 */
public class TestDefaultMethod_01 {
    private static MyArrayList<UserDto> uList;
    static  {
        uList=  new MyArrayList<>();
        uList.add(new UserDto(35,"zs","126xxx@126.com",800,"lv4"));
        uList.add(new UserDto(60,"js_li","157xxx@139.com",500,"lv3"));
        uList.add(new UserDto(78,"fc_007","126@126.com",260,"lv2"));
    }

    public static void main(String[] args) {
        /**
         * 这里以测试数据为例
         */
        System.out.println("----------集合遍历-->原始遍历方法---------");
        for(UserDto u:uList){
            System.out.println(u);
        }
        System.out.println("----------集合遍历-->自定义接口默认方法---------");
        // 使用自定义的接口默认方法实现集合元素遍历
        uList.myForeach(uList);
        // 使用Java8 提供的默认方法实现集合遍历
        System.out.println("----------集合遍历-->增强的List接口默认方法---------");
        uList.forEach(System.out::println);



    }
}
