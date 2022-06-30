package BLL;

import DAL.Tool;
import Entity.Manager;
import Entity.Student;
import Entity.Teacher;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentServer {

    public static Student login(String SQL){
        Student student = null;
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                student = new Student();
                student.setSid(rs.getInt(1));
                student.setPassword(rs.getString(2));
                student.setName(rs.getString(3));
                student.setSex(rs.getString(4));
                student.setDateOfBirth(LocalDate.parse(rs.getString(5)));
                student.setCollege(rs.getString(6));
                student.setMajor(rs.getString(7));
                student.setStuClass(rs.getString(8));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    public static Integer insert(Student student){
        Integer id = Tool.getID();
        student.setSid(id);
        String sql = "insert into Student values(?,?,?,?,?,?,?,?)";
        try {
            Connection con = Tool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2,student.getPassword());
            pstmt.setString(3,student.getName());
            pstmt.setString(4,student.getSex());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            pstmt.setString(5,dateTimeFormatter.format(student.getDateOfBirth()));
            pstmt.setString(6,student.getCollege());
            pstmt.setString(7,student.getMajor());
            pstmt.setString(8,student.getStuClass());

            int i = pstmt.executeUpdate();
            if (i>0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
            Tool.close(con,null,null,pstmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return id;
    }
    public static void List(){
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM student");
            int count =0 ;
            while (rs.next()) {
                System.out.println("id="+rs.getInt(1) + ",姓名=" +rs.getString(3)+",性别="+rs.getString(4)
                        +",出生年月="+rs.getString(5)+",所在学院=" + rs.getString(6)+",所学专业="+ rs.getString(7)
                        + ",所在班级="+rs.getString(8));
                count++;
            }
            if (count == 0){

                System.out.println("没有数据");
            }
            Tool.close(con,statement,rs,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Student getByID(Integer id){
        Student student = new Student();
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Student where sid = "+ id);
            int count = 0;
            while (rs.next()) {

                student.setSid(rs.getInt(1));
                student.setPassword(rs.getString(2));
                student.setName(rs.getString(3));
                student.setSex(rs.getString(4));
                student.setDateOfBirth(LocalDate.parse(rs.getString(5)));
                student.setCollege(rs.getString(6));
                student.setMajor(rs.getString(7));
                student.setStuClass(rs.getString(8));
                System.out.println("id="+rs.getInt(1) + ",姓名=" +rs.getString(3)+",性别="+rs.getString(4)
                        +",出生年月="+rs.getString(5)+",所在学院=" + rs.getString(6)+",所学专业="+ rs.getString(7)
                        + ",所在班级="+rs.getString(8));
                count++;
            }
            if (count == 0){
                System.out.println("查无此人!!");
                return null;
            }
            Tool.close(con,statement,rs,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    public static void getByClass(String stuClass){
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Student where stuClass = '"+ stuClass+"'");
            int count = 0;
            while (rs.next()) {
                System.out.println("id="+rs.getInt(1) + ",姓名=" +rs.getString(3)+",性别="+rs.getString(4)
                        +",出生年月="+rs.getString(5)+",所在学院=" + rs.getString(6)+",所学专业="+ rs.getString(7)
                        + ",所在班级="+rs.getString(8));
                count++;
            }
            if (count == 0){
                System.out.println("查无此人!!");
            }
            Tool.close(con,statement,rs,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void update(Student student){
        String sql = "UPDATE Student SET password = ?,name=?,sex=?,dateOfBirth=?,college=?,majoy=?,stuClass=? where sid = ?";
        try {
            Connection con = Tool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,student.getPassword());
            pstmt.setString(2,student.getName());
            pstmt.setString(3,student.getSex());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            pstmt.setString(4,dateTimeFormatter.format(student.getDateOfBirth()));
            pstmt.setString(5,student.getCollege());
            pstmt.setString(6,student.getMajor());
            pstmt.setString(7,student.getStuClass());

            pstmt.setInt(8,student.getSid());
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
    public static void delete(Integer id){
        String sql = "Delete FROM Student where sid = ?";
        try {
            Connection con = Tool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);
            int i = pstmt.executeUpdate();
            if (i>0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
            Tool.close(con,null,null,pstmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
