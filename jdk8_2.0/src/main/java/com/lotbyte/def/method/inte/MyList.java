package com.lotbyte.def.method.inte;

import java.util.List;

/**
 * @author lp
 * @Date 2019/3/27 17:36
 * @Version 1.0
 * 定义MyList 接口 并提供myForeach 默认方法
 */
public interface MyList<T> {
    /**
     * 定义接口默认方法
     * @param t
     */
   default public  void myForeach(List<T> t){
       for(Object o:t){
           System.out.println(o);
       }
   }
}
