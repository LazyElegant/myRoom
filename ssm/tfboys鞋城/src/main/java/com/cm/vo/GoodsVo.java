package com.cm.vo;

/**
 * @Author admin
 * @create 2022/5/21 11:04
 */
public class GoodsVo {
    private Integer id;
    private String name;
    private String classify;
    private String seller;
    private String content;
    private String imgUrl;

    public GoodsVo() {
    }

    public GoodsVo(Integer id, String name, String classify, String seller, String content, String imgUrl) {
        this.id = id;
        this.name = name;
        this.classify = classify;
        this.seller = seller;
        this.content = content;
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

    @Override
    public String toString() {
        return "GoodsVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classify='" + classify + '\'' +
                ", seller='" + seller + '\'' +
                ", content='" + content + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
