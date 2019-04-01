package com.lotbyte.def.method;

import com.lotbyte.def.method.data.UserRepository;

/**
 * @author lp
 * @Date 2019/4/1 12:02
 * @Version 1.0
 *  案例03  接口方法测试
 */
public class TestCase03 {
    public static void main(String[] args) {
        // 此时就近原则
        new UserRepository().findAll();
    }
}
