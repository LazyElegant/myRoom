package com.bobo.test.pojo;

public class Review {

    private int news_num;
    private String review_text;
    private String review_author;
    private String review_date;

    public Review() {
    }

    public Review(int news_num, String review_text, String review_author, String review_date) {
        this.news_num = news_num;
        this.review_text = review_text;
        this.review_author = review_author;
        this.review_date = review_date;
    }

    public int getNews_num() {
        return news_num;
    }

    public void setNews_num(int news_num) {
        this.news_num = news_num;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public String getReview_author() {
        return review_author;
    }

    public void setReview_author(String review_author) {
        this.review_author = review_author;
    }

    public String getReview_date() {
        return review_date;
    }

    public void setReview_date(String review_date) {
        this.review_date = review_date;
    }

    @Override
    public String toString() {
        return "review{" +
                "news_num=" + news_num +
                ", review_text='" + review_text + '\'' +
                ", review_author='" + review_author + '\'' +
                ", review_date='" + review_date + '\'' +
                '}';
    }
}
