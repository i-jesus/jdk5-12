package com.lotbyte.function.po;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lp
 * @Date 2019/3/26 14:00
 * @Version 1.0
 */
@Data
public class Goods {
    // 商品id
    private Integer id;
    // 商品名
    private String name;
    // 商品销量
    private Integer sale;
    // 商品评论数
    private Integer comment;
    // 商品价格 使用BigDecimal 标识
    private BigDecimal price;
    public Goods(Integer id, String name, Integer sale, Integer comment, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.sale = sale;
        this.comment = comment;
        this.price = price;
    }
}
