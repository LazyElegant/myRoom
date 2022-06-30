package com.bobo.test.vo;

public class ListIkonVo {

    private Integer id;
    private String pic;
    private String title;
    private String author;

    public ListIkonVo() {
    }

    public ListIkonVo(Integer id, String pic, String title, String author) {
        this.id = id;
        this.pic = pic;
        this.title = title;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ListIkonVo{" +
                "id=" + id +
                ", pic='" + pic + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
