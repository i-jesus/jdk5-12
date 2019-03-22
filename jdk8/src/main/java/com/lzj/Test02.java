package com.lzj;

import java.io.FileFilter;

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

    }
}
