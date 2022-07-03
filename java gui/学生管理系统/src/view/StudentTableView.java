package view;

import pojo.Students;
import util.DbUtil;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentTableView  extends JFrame {
    public StudentTableView(){

        setTitle("学生管理系统");
        String[] tableHeads = new String[]{"编号","姓名","年龄","学号","性别"};
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300,800,700,500);
        ArrayList<Students> students = new ArrayList<>();
        Connection con = DbUtil.getCon();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM students" );

            while (rs.next()) {
                Students student = new Students();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setAge(rs.getInt(3));
                student.setNumber(rs.getString(4));
                student.setSex(rs.getString(5));
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String[][] studentList = new String[students.size()][5];
        for (int i = 0; i < students.size(); i++) {
            Students student = students.get(i);
            studentList[i][0] = String.valueOf(student.getId());
            studentList[i][1] = student.getName();
            studentList[i][2] = String.valueOf(student.getAge());
            studentList[i][3] = student.getNumber();
            studentList[i][4] = student.getSex();
        }
        JTable table = new JTable(studentList,tableHeads);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.pink);
        table.setRowHeight(30);
        table.setFont(new Font("楷体", Font.PLAIN, 16));
        JScrollPane jsp = new JScrollPane(table);
        tableHeader.setBackground(Color.orange);
        getContentPane().add(jsp, BorderLayout.CENTER);
    }
}
