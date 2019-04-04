package com.lotbyte.optinal;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * @author lp
 * @Date 2019/4/4 11:51
 * @Version 1.0
 * filter 值过滤操作
 * 1-页面转发
 * 2-sql拼接
 */
public class TestCase03 {
    public static void main(String[] args) {
        String action = "main";
        Optional<String> optional = Optional.ofNullable(action);
        String page = optional.filter(a -> a.trim().equals("") || a.equals("main")).map((str) -> {
            System.out.println("转发到主页面");
            return "main";
        }).orElseGet(() -> {
            System.out.println("抓发到首页面");
            return "index";
        });
        System.out.println("转发页面-->" + page);


        /**
         * 多条件查询下的sql 拼接操作
         */
        String title = "";
        String type = "";
        StringBuilder sqlBuilder = new StringBuilder("select * from blog where user_id=2019 ");
        Optional.ofNullable(title).filter(StringUtils::isNoneBlank).ifPresent(t -> {
            sqlBuilder.append(" and title " + "%" + title + "%");
        });
        Optional.ofNullable(type).filter(t -> !t.trim().equals("") && !t.equals("1")).ifPresent(t -> {
            sqlBuilder.append(" and  type = " + type);
        });
        System.out.println(sqlBuilder.toString());
    }
}
