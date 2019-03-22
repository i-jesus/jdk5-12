package com.lzj;

import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lp
 * @Date 2019/3/22 11:18
 * @Version 1.0
 */
public class Test02 {
    public static void main(String[] args) {
        ICollectionService c01=()->{
            System.out.println("这是集合打印接口实现方法...");
        };
        c01.print();


        List<String> list = Arrays.asList("aa", "bb", "cc");
        Stream<Stream<Character>> stream = list.stream()
                .map(Test02::filterCharacter);// {{a, a}, {b, b}, {c, c}}
        stream.forEach(System.out::println);



    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();

        for (Character character : str.toCharArray()) {
            list.add(character);
        }

        //list.forEach(System.out::println);

        return list.stream();
    }

}
