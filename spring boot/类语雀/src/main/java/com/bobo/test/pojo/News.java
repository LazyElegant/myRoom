package com.bobo.test.pojo;

public class News {

    private int news_num;
    private String news_ify;
    private String news_head;
    private String news_pic;
    private String news_author_num;
    private String news_text;
    private String current_state;
    private String news_date;

    public News() {
    }

    public News(int news_num, String news_ify, String news_head, String news_pic, String news_author_num, String news_text, String current_state, String news_date) {
        this.news_num = news_num;
        this.news_ify = news_ify;
        this.news_head = news_head;
        this.news_pic = news_pic;
        this.news_author_num = news_author_num;
        this.news_text = news_text;
        this.current_state = current_state;
        this.news_date = news_date;
    }

    public int getNews_num() {
        return news_num;
    }

    public void setNews_num(int news_num) {
        this.news_num = news_num;
    }

    public String getNews_ify() {
        return news_ify;
    }

    public void setNews_ify(String news_ify) {
        this.news_ify = news_ify;
    }

    public String getNews_head() {
        return news_head;
    }

    public void setNews_head(String news_head) {
        this.news_head = news_head;
    }

    public String getNews_pic() {
        return news_pic;
    }

    public void setNews_pic(String news_pic) {
        this.news_pic = news_pic;
    }

    public String getNews_author_num() {
        return news_author_num;
    }

    public void setNews_author_num(String news_author_num) {
        this.news_author_num = news_author_num;
    }

    public String getNews_text() {
        return news_text;
    }

    public void setNews_text(String news_text) {
        this.news_text = news_text;
    }

    public String getCurrent_state() {
        return current_state;
    }

    public void setCurrent_state(String current_state) {
        this.current_state = current_state;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }

    @Override
    public String toString() {
        return "News{" +
                "news_num=" + news_num +
                ", news_ify='" + news_ify + '\'' +
                ", news_head='" + news_head + '\'' +
                ", news_pic='" + news_pic + '\'' +
                ", news_author_num='" + news_author_num + '\'' +
                ", news_text='" + news_text + '\'' +
                ", current_state='" + current_state + '\'' +
                ", news_date='" + news_date + '\'' +
                '}';
    }
}
