package com.lotbyte.function;

import com.lotbyte.function.inter.MyStringInter;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;


/**
 * @author lp
 * @Date 2019/4/2 16:49
 * @Version 1.0
 */
public class TestCase01 {
    public static void main(String[] args) {
        System.out.println(MyStringInter.checkPhone().test("1890000000000"));

        /**
         * 调用默认方法操作
         */
        MyStringInter.checkPhone().test("1890000000000");
        Predicate<String> p01 = (str)->null==str||str.trim().equals("");
        p01 = StringUtils::isNoneBlank;
        /**
         * 与 或 非 情况使用
         */

        // 用户名 密码 均非空 表达式返回true
        String userName = "admin";
        System.out.println(p01.negate().test(userName));// 值存在 返回true

        // 对测试的T做多种|| 判断
        p01.or((s) -> s.equals("index")).or((s)->s.equals("main")).test("abc");


    }
}
