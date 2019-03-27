package com.lotbyte;

/**
 * @author lp
 * @Date 2019/3/21 16:41
 * @Version 1.0
 * 颜色类定义
 *    黑色-1
 *    白色-2
 *    黄色-3
 *    蓝色-4
 *    红色-5
 */
public class ColorEntity {
    public static final int BLACK=1;
    public static final int WHITE=2;
    public static final int YELLOW=3;
    public static final int BLUE=4;
    public static final int RED=5;
    private int type;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
