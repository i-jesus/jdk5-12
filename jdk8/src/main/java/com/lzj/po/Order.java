package com.lzj.po;

import java.util.Date;

/**
 * @author lp
 * @Date 2019/3/22 17:49
 * @Version 1.0
 */
public class Order {
    // 订单id
    private Integer id;
    // 订单用户id
    private Integer userId;
    // 订单编号
    private String orderNo;
    // 订单日期
    private Date orderDate;
    // 收货地址
    private String address;
    // 创建时间
    private Date createDate;
    // 更新时间
    private Date updateDate;
    // 订单状态  0-未支付  1-已支付  2-待发货  3-已发货  4-已接收  5-已完成
    private Integer status;
    // 是否有效  1-有效订单  0-无效订单
    private Integer isValid;

    //订单总金额
    private  Double total;

    public Order(Integer id, Integer userId, String orderNo, Date orderDate, String address,
                 Date createDate, Date updateDate, Integer status, Integer isValid,Double total) {
        this.id = id;
        this.userId = userId;
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.address = address;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
        this.isValid = isValid;
        this.total=total;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderNo='" + orderNo + '\'' +
                ", orderDate=" + orderDate +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", status=" + status +
                ", isValid=" + isValid +
                '}';
    }

    /**
     * 重写 equals 方法
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        boolean flag = false;
        if (obj == null) {
            return flag;
        }
        Order order = (Order) obj;
        if (this == order) {
            return true;
        } else {
            return (this.orderNo.equals(order.orderNo));
        }
    }

    /**
     * 重写hashcode方法
     * @return
     */
    @Override
    public int hashCode() {
        int hashno = 7;
        hashno = 13 * hashno + (orderNo == null ? 0 : orderNo.hashCode());
        return hashno;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}
