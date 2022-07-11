package com.beans;

public class Balance {
    private Integer id;
    private Integer userId;
    private Float waterBalance;
    private Float electricBalance;

    public Balance() {
    }

    public Balance(Integer id, Integer userId, Float waterBalance, Float electricBalance) {
        this.id = id;
        this.userId = userId;
        this.waterBalance = waterBalance;
        this.electricBalance = electricBalance;
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

    public Float getWaterBalance() {
        return waterBalance;
    }

    public void setWaterBalance(Float waterBalance) {
        this.waterBalance = waterBalance;
    }

    public Float getElectricBalance() {
        return electricBalance;
    }

    public void setElectricBalance(Float electricBalance) {
        this.electricBalance = electricBalance;
    }
}
