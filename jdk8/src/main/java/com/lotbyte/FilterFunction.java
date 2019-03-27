package com.lotbyte;

import com.lotbyte.po.IPhone;

@FunctionalInterface
public interface FilterFunction {
    IPhone getPhone();
}
