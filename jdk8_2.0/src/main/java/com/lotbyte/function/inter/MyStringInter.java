package com.lotbyte.function.inter;


import java.util.function.Predicate;
import java.util.regex.Pattern;

public interface MyStringInter {
    public final  String checkPhone= "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(16[0-9])|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
    /**
     * 用户手机格式合法性
     *     返回L函数式接口Predicate 的实现  Lambda表达式
     * @return
     */
    static Predicate<String> checkPhone(){
          return (e)-> {
              return Pattern.compile(checkPhone).matcher(e).matches();
          };
    }



}
