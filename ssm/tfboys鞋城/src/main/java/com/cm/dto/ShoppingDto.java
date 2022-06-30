package com.cm.dto;

/**
 * @Author admin
 * @create 2022/5/21 17:53
 */
public class ShoppingDto {
    private Integer id;
    private String imgUrl;
    private String name;
    private Double current;
    private Integer amount;
    private Integer goodsId;
    private Integer size;

    public ShoppingDto() {
    }

    public ShoppingDto(Integer id, String imgUrl, String name, Double current, Integer amount, Integer goodsId, Integer size) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.current = current;
        this.amount = amount;
        this.goodsId = goodsId;
        this.size = size;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrent() {
        return current;
    }

    public void setCurrent(Double current) {
        this.current = current;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ShoppingDto{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", name='" + name + '\'' +
                ", current=" + current +
                ", amount=" + amount +
                ", size=" + size +
                '}';
    }
}
