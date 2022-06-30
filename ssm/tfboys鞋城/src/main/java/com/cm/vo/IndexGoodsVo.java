package com.cm.vo;

/**
 * @Author admin
 * @create 2022/5/21 11:04
 */
public class IndexGoodsVo {
    private Integer id;
    private String name;
    private String classify;
    private String seller;
    private String content;
    private String imgUrl;
    private Double original;
    private Double current;


    public IndexGoodsVo() {
    }

    public IndexGoodsVo(Integer id, String name, String classify, String seller, String content, String imgUrl, Double original, Double current) {
        this.id = id;
        this.name = name;
        this.classify = classify;
        this.seller = seller;
        this.content = content;
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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "IndexGoodsVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classify='" + classify + '\'' +
                ", seller='" + seller + '\'' +
                ", content='" + content + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", original=" + original +
                ", current=" + current +
                '}';
    }
}
