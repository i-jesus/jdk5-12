package com.lzj;

import com.lzj.po.IPhone;

@FunctionalInterface
public interface FilterFunction {
    IPhone getPhone();
}
