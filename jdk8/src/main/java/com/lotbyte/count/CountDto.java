package com.lotbyte.count;

/**
 * @author lp
 * @Date 2019/3/25 16:34
 * @Version 1.0
 */
public class CountDto {
    private String name;
    private Object y;

    public CountDto(String name, Object y) {
        this.name = name;
        this.y = y;
    }

    @Override
    public String toString() {
        return "CountDto{" +
                "name='" + name + '\'' +
                ", y=" + y +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }
}
