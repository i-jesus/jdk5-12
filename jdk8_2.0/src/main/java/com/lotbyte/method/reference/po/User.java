package com.lotbyte.method.reference.po;

import lombok.Data;

/**
 * @author lp
 * @Date 2019/4/3 15:59
 * @Version 1.0
 */

public class User {
    private Integer id;
    private String userName;
    private String addr;


    public User(Integer id, String userName, String addr) {
        this.id = id;
        this.userName = userName;
        this.addr = addr;
    }

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public  String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }


}
