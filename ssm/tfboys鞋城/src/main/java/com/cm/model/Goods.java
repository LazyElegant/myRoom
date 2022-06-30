package com.cm.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @Author admin
 * @create 2022/5/20 20:52
 */
public class Goods {

    private Integer id;
    private String name;
    private Integer classifyId;
    private Integer sellerId;
    private String content;
    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registrationDate;
    private String imgUrl;
    private Double original;
    private Double current;


    public Goods() {
    }

    public Goods(Integer id, String name, Integer classifyId, Integer sellerId, String content, LocalDateTime registrationDate, String imgUrl, Double original, Double current) {
        this.id = id;
        this.name = name;
        this.classifyId = classifyId;
        this.sellerId = sellerId;
        this.content = content;
        this.registrationDate = registrationDate;
        this.imgUrl = imgUrl;
        this.original = original;
        this.current = current;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getOriginal() {
        return original;
    }

    public void setOriginal(Double original) {
        this.original = original;
    }

    public Double getCurrent() {
        return current;
    }

    public void setCurrent(Double current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classifyId=" + classifyId +
                ", sellerId=" + sellerId +
                ", content='" + content + '\'' +
                ", registrationDate=" + registrationDate +
                ", imgUrl='" + imgUrl + '\'' +
                ", original=" + original +
                ", current=" + current +
                '}';
    }
}
