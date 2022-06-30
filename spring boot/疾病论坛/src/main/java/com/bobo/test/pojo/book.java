package com.bobo.test.pojo;

public class book {
    private int id;
    private String book_name;
    private String book_publishing;
    private String book_author;
    private String book_explain;
    private int book_user_id;
    private String book_photo;

    public book() {
    }

    public book(int id, String book_name, String book_publishing, String book_author, String book_explain, int book_user_id, String book_photo) {
        this.id = id;
        this.book_name = book_name;
        this.book_publishing = book_publishing;
        this.book_author = book_author;
        this.book_explain = book_explain;
        this.book_user_id = book_user_id;
        this.book_photo = book_photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_publishing() {
        return book_publishing;
    }

    public void setBook_publishing(String book_publishing) {
        this.book_publishing = book_publishing;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_explain() {
        return book_explain;
    }

    public void setBook_explain(String book_explain) {
        this.book_explain = book_explain;
    }

    public int getBook_user_id() {
        return book_user_id;
    }

    public void setBook_user_id(int book_user_id) {
        this.book_user_id = book_user_id;
    }

    public String getBook_photo() {
        return book_photo;
    }

    public void setBook_photo(String book_photo) {
        this.book_photo = book_photo;
    }


    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", book_publishing='" + book_publishing + '\'' +
                ", book_author='" + book_author + '\'' +
                ", book_explain='" + book_explain + '\'' +
                ", book_user_id=" + book_user_id +
                ", book_photo='" + book_photo + '\'' +
                '}';
    }
}
