package book;

/**
 * 借书记录类
 */
public class Borrow {
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 借阅的图书id
     */
    private Integer bookId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId;
    }
}
