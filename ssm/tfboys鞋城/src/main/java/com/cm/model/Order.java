package com.cm.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @Author admin
 * @create 2022/5/21 23:22
 */
public class Order {

    private Integer id;
    private Integer buyerId;

    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registrationDate;
    private Integer goodsId;
    private Integer shoppingId;
    private Integer amount;
    private Double sum;
    private Integer size;
    private Integer status;
    private Integer addressId;
    public Order() {
    }

    public Order(Integer id, Integer buyerId, LocalDateTime registrationDate, Integer goodsId, Integer shoppingId, Integer amount, Double sum, Integer size, Integer status, Integer addressId) {
        this.id = id;
        this.buyerId = buyerId;
        this.registrationDate = registrationDate;
        this.goodsId = goodsId;
        this.shoppingId = shoppingId;
        this.amount = amount;
        this.sum = sum;
        this.size = size;
        this.status = status;
        this.addressId = addressId;
    }

    public Integer getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(Integer shoppingId) {
        this.shoppingId = shoppingId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buyerId=" + buyerId +
                ", registrationDate=" + registrationDate +
                ", goodsId=" + goodsId +
                ", amount=" + amount +
                ", sum=" + sum +
                ", size=" + size +
                ", status=" + status +
                '}';
    }
}
