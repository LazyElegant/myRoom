package com.beans;

public class Bill {
    private Integer id;
    private Integer userId;
    private Integer type;
    private Float money;
    private Integer state;
    private String month;

    public Bill() {
    }

    public Bill(Integer id, Integer userId, Integer type, Float money, Integer state, String month) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.money = money;
        this.state = state;
        this.month = month;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", userId=" + userId +
                ", type=" + type +
                ", money=" + money +
                ", state=" + state +
                ", month='" + month + '\'' +
                '}';
    }
}
