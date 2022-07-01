package view;

import model.Book;
import util.DbUtil;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookTableView extends JFrame {
    public BookTableView(){
        setTitle("图书信息");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300,800,700,500);
        ArrayList<Book> bookArrayList = new ArrayList<>();
        Connection con = DbUtil.getCon();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM book" );

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setPrice(rs.getFloat(3));
                book.setNumber(rs.getInt(4));
                bookArrayList.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String[] tableHeads = new String[]{"编号","书名","价格","数量"};

        String[][] books = new String[bookArrayList.size()][4];
        for (int i = 0; i < bookArrayList.size(); i++) {
            Book book = bookArrayList.get(i);
            books[i][0] = String.valueOf(book.getId());
            books[i][1] = book.getName();
            books[i][2] = String.valueOf(book.getPrice());
            books[i][3] = String.valueOf(book.getNumber());
        }
        JTable table = new JTable(books,tableHeads);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.pink);
        table.setRowHeight(30);
        table.setFont(new Font("宋体", Font.PLAIN, 18));
        JScrollPane jsp = new JScrollPane(table);
        getContentPane().add(jsp, BorderLayout.CENTER);

    }

}
