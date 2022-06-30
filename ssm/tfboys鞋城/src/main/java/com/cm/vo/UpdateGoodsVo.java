package com.cm.vo;

/**
 * @Author admin
 * @create 2022/5/21 11:04
 */
public class UpdateGoodsVo {
    private Integer id;
    private String name;
    private Integer classifyId;
    private String classify;
    private Double original;
    private Double current;
    private String imgUrl;
    private String content;

    public UpdateGoodsVo() {
    }

    public UpdateGoodsVo(Integer id, String name, Integer classifyId, String classify, Double original, Double current, String imgUrl, String content) {
        this.id = id;
        this.name = name;
        this.classifyId = classifyId;
        this.classify = classify;
        this.original = original;
        this.current = current;
        this.imgUrl = imgUrl;
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "UpdateGoodsVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classifyId=" + classifyId +
                ", classify='" + classify + '\'' +
                ", original=" + original +
                ", current=" + current +
                ", content='" + content + '\'' +
                '}';
    }
}
