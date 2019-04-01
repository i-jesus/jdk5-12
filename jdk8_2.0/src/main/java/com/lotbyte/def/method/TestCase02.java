package com.lotbyte.def.method;

import com.lotbyte.lambda.UserService;
import com.lotbyte.po.User;

/**
 * @author lp
 * @Date 2019/4/1 11:32
 * @Version 1.0
 * 案例02  单例对象构建与获取
 */
public class TestCase02 {
    public static void main(String[] args) {
        UserService userService01 = SingletonFactory.getInstance(new UserService().getClass());
        UserService userService02 = SingletonFactory.getInstance(new UserService().getClass());
        System.out.println(userService01+"---"+userService02);
    }
}
