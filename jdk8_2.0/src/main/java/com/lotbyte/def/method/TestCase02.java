package com.lotbyte.def.method;

import com.lotbyte.def.method.inte.MyArrayList;
import com.lotbyte.def.method.po.UserDto;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author lp
 * @Date 2019/3/27 17:13
 * @Version 1.0
 */
public class TestCase02 {
    private static MyArrayList<UserDto> uList;
    static  {
        uList=  new MyArrayList<>();
        uList.add(new UserDto(35,"zs","126xxx@126.com",800,"lv4"));
        uList.add(new UserDto(60,"js_li","157xxx@139.com",500,"lv3"));
        uList.add(new UserDto(78,"fc_007","126@126.com",260,"lv2"));
    }

    public static void main(String[] args) {
        System.out.println("--------Collections.sort 实现按文章发表量排序---------");
        Collections.sort(uList, new Comparator<UserDto>() {
            @Override
            public int compare(UserDto o1, UserDto o2) {
                return o1.getTotal()-o2.getTotal();
            }
        });
        uList.forEach(System.out::println);

        System.out.println("--------集合默认sort方法实现按文章发表量排序---------");
        uList.sort(new Comparator<UserDto>() {
            @Override
            public int compare(UserDto o1, UserDto o2) {
                return o1.getTotal()-o2.getTotal();
            }
        });
        uList.forEach(System.out::println);


       System.out.println("--------Stream实现按文章发表量排序---------");
       List<UserDto> result= uList.stream().sorted(new Comparator<UserDto>() {
            @Override
            public int compare(UserDto o1, UserDto o2) {
                return o1.getTotal()-o2.getTotal();
            }
        }).collect(Collectors.toList());
       result.forEach(System.out::println);

    }
}
