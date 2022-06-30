package com.cm.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @Author admin
 * @create 2022/5/21 17:41
 */
public class Shopping {

    private Integer id;
    private Integer goodsId;
    private Integer amount;
    private Integer buyerId;
    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registrationDate;
    private Integer size;

    public Shopping() {
    }

    public Shopping(Integer id, Integer goodsId, Integer amount, Integer buyerId, LocalDateTime registrationDate, Integer size) {
        this.id = id;
        this.goodsId = goodsId;
        this.amount = amount;
        this.buyerId = buyerId;
        this.registrationDate = registrationDate;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", amount=" + amount +
                ", buyerId=" + buyerId +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
