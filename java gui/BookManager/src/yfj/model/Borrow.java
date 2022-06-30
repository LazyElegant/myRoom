package yfj.model;

import java.sql.Time;
import java.time.LocalDateTime;

/**
 * @Author admin
 * @create 2021/12/21 20:38
 */
public class Borrow {
    private Integer id;
    private Integer bookId;
    private Integer borrowerId;
    private String borrowTime;
    private String contact;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Borrow(Integer bookId, Integer borrowerId, String borrowTime, String contact,Integer count) {
        this.bookId = bookId;
        this.borrowerId = borrowerId;
        this.borrowTime = borrowTime;
        this.contact = contact;
        this.count = count;
    }


}
