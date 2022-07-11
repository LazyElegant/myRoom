package com.vo;

public class BalanceVo {
    private Integer userId;
    private String username;
    private Float waterBalance;
    private Float electricBalance;


    public BalanceVo(Integer userId, String username, Float waterBalance, Float electricBalance) {
        this.userId = userId;
        this.username = username;
        this.waterBalance = waterBalance;
        this.electricBalance = electricBalance;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "BalanceVo{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", waterBalance=" + waterBalance +
                ", electricBalance=" + electricBalance +
                '}';
    }
}
