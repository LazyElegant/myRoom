package com.cm.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * @Author admin
 * @create 2022/5/20 20:52
 */
public class UpdateGoodsDto {

    private Integer id;
    private String name;
    private Integer classifyId;
    private String content;
    private Double original;
    private Double current;

    public UpdateGoodsDto() {
    }

    public UpdateGoodsDto(Integer id, String name, Integer classifyId, String content, Double original, Double current) {
        this.id = id;
        this.name = name;
        this.classifyId = classifyId;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "UpdateGoodsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classifyId=" + classifyId +
                ", content='" + content + '\'' +
                ", original=" + original +
                ", current=" + current +
                '}';
    }
}
