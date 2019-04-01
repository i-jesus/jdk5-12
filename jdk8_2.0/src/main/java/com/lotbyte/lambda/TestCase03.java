package com.lotbyte.lambda;

import com.lotbyte.lambda.service.UserService;

/**
 * @author lp
 * @Date 2019/4/1 18:05
 * @Version 1.0
 */
public class TestCase03 {
    public static void main(String[] args) {
        new UserService().login("admin", "admin");
    }
}
