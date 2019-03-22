package com.lzj.po;

import java.util.Date;

/**
 * @author lp
 * @Date 2019/3/22 14:41
 * @Version 1.0
 */
public class IPhone {
    private Integer id;
    private String version;
    private Date createTime;
    private String name;

    public IPhone() {
    }

    public IPhone(Integer id) {
        this.id = id;
    }

    public IPhone(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public  static  void info(){
        System.out.println("这是一部IPhone");
    }

    public  void mm(){
        System.out.println("成员方法测试。。。");
    }

    public  void mm02(String str){
        System.out.println(str);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
