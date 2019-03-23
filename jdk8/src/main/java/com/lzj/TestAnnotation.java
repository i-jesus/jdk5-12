package com.lzj;

import com.lzj.annotations.MyParam;
import com.lzj.annotations.MyParams;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author lp
 * @Date 2019/3/23 15:59
 * @Version 1.0
 */
public class TestAnnotation {

    private MyParam param;// 定义成员变量param 类型为MyParam 注解类型

    @MyParam("hello")
    @MyParam("java8")
    public  void testAnnotation(){
        System.out.println("可重复注解测试...");
    }

    public static void main(String[] args)  throws  Exception{
        /**
         * 查找指定方法级别注解 遍历输出注解value 值
         */
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method method = clazz.getMethod("testAnnotation");
        MyParam[] params = method.getAnnotationsByType(MyParam.class);
        for (MyParam param : params) {
            System.out.println(param.value());
        }

        // 获取成员变量 并输出变量类型
        Field field= clazz.getDeclaredField("param");
        System.out.println(field);
        System.out.println(field.getType());
    }
}
