package com.lotbyte.def.method.po;

import lombok.Data;

/**
 * @author lp
 * @Date 2019/3/27 17:14
 * @Version 1.0
 * 用户实体包装类-接收数据库返回统计结果
 */
@Data
public class UserDto {
    // 用户id
    private Integer id;
    // 用户名
    private String userName;
    // 用户头像地址
    private String image;
    // 用户邮箱
    private String email;
    // 文章发表数统计
    private Integer total;
    // 用户级别
    private String level;

    public UserDto(Integer id, String userName, String email, Integer total, String level) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.total = total;
        this.level = level;
    }
}
