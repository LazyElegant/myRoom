package BLL;

import DAL.Tool;
import Entity.Course;
import Entity.Score;
import Entity.Student;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CourseServer {

    public static Integer insert(Course course){
        Integer id = Tool.getID();
        course.setCid(id);
        String sql = "insert into Course values(?,?,?,?)";
        try {
            Connection con = Tool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2,course.getCname());
            pstmt.setInt(3,course.getTid());
            pstmt.setString(4,course.getStuClass());
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
            ResultSet rs = statement.executeQuery("SELECT * FROM Course");
            int count =0 ;
            while (rs.next()) {
                System.out.println("id="+rs.getInt(1) + ",课程名=" +rs.getString(2)+",教师id="+rs.getString(3) +",上课班级="+rs.getString(4));
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

    public static void ListSid(Integer cid){
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT c.cid,s.sid FROM Course c LEFT JOIN Student s on s.stuClass =c.stuClass where c.cid = " + cid);
            int count =0 ;
            while (rs.next()) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("cid="+rs.getInt(1) + ",sid=" +rs.getInt(2));
                System.out.println("录入该学生的成绩:");
                Score score = new Score();
                score.setSid(rs.getInt(2));
                score.setCid(rs.getInt(1));
                score.setScore(Float.valueOf(scanner.nextLine()));
                ScoreServer.insert(score);
                System.out.println(score);
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

    public static Course getByID(Integer id){
        Course course = new Course();
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Course where cid = "+ id);
            int count = 0;
            while (rs.next()) {

                course.setCid(rs.getInt(1));
                course.setCname(rs.getString(2));
                course.setTid(rs.getInt(3));
                course.setStuClass(rs.getString(4));
                System.out.println("id="+rs.getInt(1) + ",课程名=" +rs.getString(2)+",教师id="+rs.getString(3) +",上课班级="+rs.getString(4));
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
        return course;
    }

    public static void getByName(String name){
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Course where cname ='"+name+"'");
            int count = 0;
            while (rs.next()) {
                System.out.println("id="+rs.getInt(1) + ",课程名=" +rs.getString(2)+",教师id="+rs.getString(3) +",上课班级="+rs.getString(4));
                count++;
            }
            if (count == 0){
                System.out.println("查无课程!!");
            }
            Tool.close(con,statement,rs,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void getByTid(Integer tid){
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Course where tid = "+ tid);
            int count = 0;
            while (rs.next()) {
                System.out.println("id="+rs.getInt(1) + ",课程名=" +rs.getString(2)+",教师id="+rs.getString(3) +",上课班级="+rs.getString(4));
                count++;
            }
            if (count == 0){
                System.out.println("查无课程!!");
            }
            Tool.close(con,statement,rs,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void getByClass(String stuClass){
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Course where stuClass = '"+ stuClass+"'");
            int count = 0;
            while (rs.next()) {
                System.out.println("id="+rs.getInt(1) + ",课程名=" +rs.getString(2)+",教师id="+rs.getString(3) +",上课班级="+rs.getString(4));
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

    public static void update(Course course){
        String sql = "UPDATE Course SET cname = ?,tid=?,stuClass=? where cid = ?";
        try {
            Connection con = Tool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,course.getCname());
            pstmt.setInt(2,course.getTid());
            pstmt.setString(3,course.getStuClass());
            pstmt.setInt(4,course.getCid());

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
        String sql = "Delete FROM Course where cid = ?";
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
