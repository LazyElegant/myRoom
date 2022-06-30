package com.cm.vo;

/**
 * @Author admin
 * @create 2022/5/21 23:01
 */
public class ShoppingVo {
    private Integer amount;
    private Double money;
    private Integer size;

    public ShoppingVo() {
    }

    public ShoppingVo(Integer amount, Double money, Integer size) {
        this.amount = amount;
        this.money = money;
        this.size = size;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ShoppingVo{" +
                "amount=" + amount +
                ", money=" + money +
                ", size=" + size +
                '}';
    }
}
