package yfj.dao;

import yfj.model.Book;
import yfj.model.Borrow;
import yfj.util.StringUtil;
import yfj.view.LoginView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class BorrowDao {

    BookDao bookDao = new BookDao();


    /**
     * 遍历图书遍历
     * @param con
     * @return
     * @throws Exception
     */
    public ResultSet list(Connection con) throws Exception{
        //select * from t_book b,t_booktype bt where b.bookTypeId = bt.id;
        StringBuffer sb = new StringBuffer("SELECT  b.id," +
                "tb.id `bookId`," +
                "tb.bookName,\n" +
                "\t\t\t tb.author,\n" +
                "\t\t\t b.contact,\n" +
                "\t\t\t b.`count`,\n" +
                "\t\t\t b.borrow_time 'borrowTime'\n" +
                "\t\t\t\t FROM `t_borrow` b\n" +
                "LEFT JOIN t_book tb ON tb.id = b.book_id\n" +
                "WHERE b.borrower_id = "+ LoginView.getLogin_id() +"\n");

        PreparedStatement pstmt = con.prepareStatement(sb.toString());

        return pstmt.executeQuery();
    }

    /**
     * 添加借阅记录
     * @param con
     * @param borrow
     * @return
     * @throws Exception
     */
    public int add(Connection con, Borrow borrow) throws Exception{
        String sql = "insert into t_borrow values(null,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, borrow.getBookId());
        pstmt.setInt(2, borrow.getBorrowerId());
        pstmt.setString(3, borrow.getBorrowTime());
        pstmt.setString(4, borrow.getContact());
        pstmt.setInt(5, borrow.getCount());

        return pstmt.executeUpdate();
    }

    /**
     * 添加借阅记录
     * @param con
     * @param id
     * @return
     * @throws Exception
     */
    public int delete(Connection con, Integer id) throws Exception{
        String sql = "DELETE FROM t_borrow WHERE id = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, id);
        return pstmt.executeUpdate();
    }
}
