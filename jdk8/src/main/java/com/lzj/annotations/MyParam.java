package com.lzj.annotations;

import java.lang.annotation.*;


/**
 * 定义可重复注解  类型注解
 */
@Repeatable(MyParams.class)
@Target({ ElementType.FIELD, ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyParam {
    String value() default "";
}
