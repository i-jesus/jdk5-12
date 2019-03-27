package com.lotbyte.utils;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author lp
 * @Date 2019/3/23 14:32
 * @Version 1.0
 */
public class MyUtil {


    /**
     * java7 的写法
     * @param str
     * @return
     */
    public  Integer strToInteger7(String str){
        if(null == str || str.trim().length()==0){
            throw  new NumberFormatException();
        }
        return Integer.parseInt(str);
    }


    /**
     * java8 改进的写法 避免调用方获取null 情况
     * @param str
     * @return
     */
    public  Optional<Integer> strToInteger8(String str){
        try {
            return Optional.of(Integer.parseInt(str));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Predicate<String> isEmpty(){
        return (str)->null==str||str.trim().isEmpty();
    }
}
