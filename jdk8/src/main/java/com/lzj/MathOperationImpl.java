package com.lzj;

/**
 * @author lp
 * @Date 2019/3/22 9:34
 * @Version 1.0
 */
public class MathOperationImpl implements  IMathOperation {
    @Override
    public int add(int a, int b) {
        // 子类中可以直接调用父类接口默认方法
        IMathOperation.super.print();
        IMathOperation.version();
        return a+b;
    }
}
