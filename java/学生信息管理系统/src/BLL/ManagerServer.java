package BLL;

import DAL.Tool;
import Entity.Course;
import Entity.Manager;
import Entity.Student;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ManagerServer {

    public static Manager login(String SQL){
        Manager manager = null;
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                manager = new Manager();
                manager.setMid(rs.getInt(1));
                manager.setPassword(rs.getString(2));
                manager.setName(rs.getString(3));
                manager.setSex(rs.getString(4));
                manager.setDateOfBirth(LocalDate.parse(rs.getString(5)));
            }
            Tool.close(con,statement,rs,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return manager;
    }
    public static void update(Manager manager){
        String sql = "UPDATE Manager SET password = ?,name=?,sex=?,dateOfBirth=? where mid = ?";
        try {
            Connection con = Tool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,manager.getPassword());
            pstmt.setString(2,manager.getName());
            pstmt.setString(3,manager.getSex());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            pstmt.setString(4,dateTimeFormatter.format(manager.getDateOfBirth()));
            pstmt.setInt(5,manager.getMid());
            int i = pstmt.executeUpdate();
            if (i>0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
            Tool.close(con,null,null,pstmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
