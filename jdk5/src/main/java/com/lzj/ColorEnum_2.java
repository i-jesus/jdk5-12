package com.lzj;

/**
 * @author lp
 * @Date 2019/3/21 16:41
 * @Version 1.0
 * 颜色枚举类2.0-实现颜色常量类功能
 */
public  enum ColorEnum_2 {
    BLACK(1),WHITE(2),YELLOW(3),BLUE(4),RED(5);
    private int type;
    ColorEnum_2(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}


