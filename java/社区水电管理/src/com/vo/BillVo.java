package com.vo;

public class BillVo {
    private Integer id;
    private String userName;
    private String type;
    private Float money;
    private String state;
    private String month;

    public BillVo() {
    }

    public BillVo(Integer id, String userName, String type, Float money, String state, String month) {
        this.id = id;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
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
        return "BillVo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", type='" + type + '\'' +
                ", money=" + money +
                ", state='" + state + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
